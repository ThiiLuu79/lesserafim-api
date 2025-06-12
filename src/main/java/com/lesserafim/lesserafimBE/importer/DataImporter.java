package com.lesserafim.lesserafimBE.importer;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.lesserafim.lesserafimBE.api.model.Discography;
import com.lesserafim.lesserafimBE.api.model.Member;
import com.lesserafim.lesserafimBE.api.model.MusicVideo;
import com.lesserafim.lesserafimBE.api.model.Timeline;
import com.lesserafim.lesserafimBE.repository.DiscographyRepository;
import com.lesserafim.lesserafimBE.repository.MemberRepository;
import com.lesserafim.lesserafimBE.repository.MusicVideoRepository;
import com.lesserafim.lesserafimBE.repository.TimelineRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;

import java.io.InputStream;
import java.util.List;

@Component
public class DataImporter implements CommandLineRunner {

    private final MemberRepository memberRepository;
    private final TimelineRepository timelineRepository;
    private final DiscographyRepository discographyRepository;
    private final MusicVideoRepository musicVideoRepository;

    public DataImporter(MemberRepository memberRepository, TimelineRepository timelineRepository, DiscographyRepository discographyRepository, MusicVideoRepository musicVideoRepository) {
        this.memberRepository = memberRepository;
        this.timelineRepository = timelineRepository;
        this.discographyRepository = discographyRepository;
        this.musicVideoRepository = musicVideoRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        ObjectMapper mapper = new ObjectMapper();

        // Members
        memberRepository.deleteAll();  // clear existing members
        InputStream membersStream = new ClassPathResource("membersData.json").getInputStream();
        List<Member> members = mapper.readValue(membersStream, new TypeReference<List<Member>>() {});
        memberRepository.saveAll(members);
        System.out.println("Imported members into MongoDB.");

        // Timeline
        timelineRepository.deleteAll();  // clear existing timeline
        InputStream timelineStream = new ClassPathResource("timelineData.json").getInputStream();
        List<Timeline> timeline = mapper.readValue(timelineStream, new TypeReference<List<Timeline>>() {});
        timelineRepository.saveAll(timeline);
        System.out.println("Imported timeline into MongoDB.");

        // Discography
        discographyRepository.deleteAll();  // clear existing discographies
        InputStream discographyStream = new ClassPathResource("discographyData.json").getInputStream();
        List<Discography> disc = mapper.readValue(discographyStream, new TypeReference<List<Discography>>() {});
        discographyRepository.saveAll(disc);
        System.out.println("Imported discographies into MongoDB.");

        // Music Videos
        musicVideoRepository.deleteAll();  // clear existing MVs
        InputStream mvStream = new ClassPathResource("musicVideoData.json").getInputStream();
        List<MusicVideo> mv = mapper.readValue(mvStream, new TypeReference<List<MusicVideo>>() {});
        musicVideoRepository.saveAll(mv);
        System.out.println("Imported mvs into MongoDB.");
    }
}

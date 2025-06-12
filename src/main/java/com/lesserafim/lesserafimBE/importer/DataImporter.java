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

    public DataImporter(MemberRepository memberRepository, TimelineRepository timelineRepository,
                        DiscographyRepository discographyRepository, MusicVideoRepository musicVideoRepository) {
        this.memberRepository = memberRepository;
        this.timelineRepository = timelineRepository;
        this.discographyRepository = discographyRepository;
        this.musicVideoRepository = musicVideoRepository;
    }

    @Override
    public void run(String... args) {
        ObjectMapper mapper = new ObjectMapper();

        // Import Members
        try (InputStream membersStream = new ClassPathResource("membersdata.json").getInputStream()) {
            List<Member> members = mapper.readValue(membersStream, new TypeReference<>() {});
            memberRepository.deleteAll();
            memberRepository.saveAll(members);
            System.out.println("✅ Imported members into MongoDB.");
        } catch (Exception e) {
            System.err.println("❌ Failed to import members: " + e.getMessage());
        }

        // Import Timeline
        try (InputStream timelineStream = new ClassPathResource("timelineData.json").getInputStream()) {
            List<Timeline> timeline = mapper.readValue(timelineStream, new TypeReference<>() {});
            timelineRepository.deleteAll();
            timelineRepository.saveAll(timeline);
            System.out.println("✅ Imported timeline into MongoDB.");
        } catch (Exception e) {
            System.err.println("❌ Failed to import timeline: " + e.getMessage());
        }

        // Import Discography
        try (InputStream discographyStream = new ClassPathResource("discographyData.json").getInputStream()) {
            List<Discography> disc = mapper.readValue(discographyStream, new TypeReference<>() {});
            discographyRepository.deleteAll();
            discographyRepository.saveAll(disc);
            System.out.println("✅ Imported discographies into MongoDB.");
        } catch (Exception e) {
            System.err.println("❌ Failed to import discographies: " + e.getMessage());
        }

        // Import Music Videos
        try (InputStream mvStream = new ClassPathResource("musicVideoData.json").getInputStream()) {
            List<MusicVideo> mv = mapper.readValue(mvStream, new TypeReference<>() {});
            musicVideoRepository.deleteAll();
            musicVideoRepository.saveAll(mv);
            System.out.println("✅ Imported music videos into MongoDB.");
        } catch (Exception e) {
            System.err.println("❌ Failed to import music videos: " + e.getMessage());
        }
    }
}

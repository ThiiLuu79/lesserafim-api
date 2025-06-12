package com.lesserafim.lesserafimBE.service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.lesserafim.lesserafimBE.api.model.MusicVideo;
import com.lesserafim.lesserafimBE.repository.MusicVideoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

@Service
public class MusicVideoService {

    private final MusicVideoRepository musicVideoRepository;
    private List<MusicVideo> musicVideos = new ArrayList<>();

    @Autowired
    public MusicVideoService(MusicVideoRepository musicVideoRepository) {
        this.musicVideoRepository = musicVideoRepository;
        loadMVFromDatabase();
    }

    private void loadMVFromDatabase() {
        try {
            List<MusicVideo> dbMv = musicVideoRepository.findAll();
            if (!dbMv.isEmpty()) {
                musicVideos = dbMv;
                System.out.println("Fetching MVs from MongoDB.");
                return;
            }
            System.out.println("No MVs found in the database.");
        } catch (Exception e) {
            System.out.println("Failed to load MVs from database: " + e.getMessage());
        }
    }

    private void loadMusicVideoFromJson() {
        ObjectMapper objectMapper = new ObjectMapper();
        try (InputStream inputStream = getClass().getClassLoader().getResourceAsStream("musicVideoData.json")) {
            if (inputStream != null) {
                musicVideos = objectMapper.readValue(inputStream, new TypeReference<List<MusicVideo>>() {});
            } else {
                throw new RuntimeException("musicVideoData.json not found in resources.");
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Failed to load music videos from JSON file.");
        }
    }

    public List<MusicVideo> getAllMusicVideos() {
        return musicVideos;
    }

    public MusicVideo getMusicVideoById(int id) {
        return musicVideos.stream()
                .filter(musicVideo -> musicVideo.getId() == id)
                .findFirst()
                .orElse(null);
    }

}

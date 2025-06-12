package com.lesserafim.lesserafimBE.service;

import com.lesserafim.lesserafimBE.api.model.MusicVideo;
import com.lesserafim.lesserafimBE.repository.MusicVideoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MusicVideoService {

    private final MusicVideoRepository musicVideoRepository;

    @Autowired
    public MusicVideoService(MusicVideoRepository musicVideoRepository) {
        this.musicVideoRepository = musicVideoRepository;
    }

    public List<MusicVideo> getAllMusicVideos() {
        // Always return up-to-date data
        return musicVideoRepository.findAll();
    }

    public MusicVideo getMusicVideoById(int id) {
        // Also reflect current database state
        return musicVideoRepository.findAll().stream()
                .filter(mv -> mv.getId() == id)
                .findFirst()
                .orElse(null);
    }
}

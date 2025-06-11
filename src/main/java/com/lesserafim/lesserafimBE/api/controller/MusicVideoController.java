package com.lesserafim.lesserafimBE.api.controller;

import com.lesserafim.lesserafimBE.api.model.MusicVideo;
import com.lesserafim.lesserafimBE.service.MusicVideoService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/musicVideos")
public class MusicVideoController {
    private final MusicVideoService musicVideoService;

    public MusicVideoController(MusicVideoService musicVideoService) {
        this.musicVideoService = musicVideoService;
    }

    @GetMapping
    public List<MusicVideo> getAllMusicVideos() {
        return musicVideoService.getAllMusicVideos();
    }

    @GetMapping("/{id}")
    public MusicVideo getMusicVideoById(@PathVariable int id) {
        return musicVideoService.getMusicVideoById(id);
    }
}

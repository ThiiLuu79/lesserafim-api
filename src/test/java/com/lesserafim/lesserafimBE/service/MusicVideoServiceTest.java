package com.lesserafim.lesserafimBE.service;

import com.lesserafim.lesserafimBE.api.model.MusicVideo;
import com.lesserafim.lesserafimBE.repository.MusicVideoRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class MusicVideoServiceTest {

    private MusicVideoService musicVideoService;
    private final MusicVideoRepository musicVideoRepository;

    public MusicVideoServiceTest(MusicVideoRepository musicVideoRepository) {
        this.musicVideoRepository = musicVideoRepository;
    }
    @BeforeEach
    public void setUp() {
        musicVideoService = new MusicVideoService(musicVideoRepository);
    }

    @Test
    public void testGetAllMVs() {
        List<MusicVideo> musicVideos = musicVideoService.getAllMusicVideos();
        assertNotNull(musicVideos);
        assertTrue(musicVideos.size() >= 1, "Music videos list should not be empty");
    }

    @Test
    public void testGetMVById_Found() {
        MusicVideo mv = musicVideoService.getMusicVideoById(1);
        assertNotNull(mv);
        assertEquals(1, mv.getId());
    }

    @Test
    public void testGetMVById_NotFound() {
        MusicVideo mv = musicVideoService.getMusicVideoById(999);
        assertNull(mv);
    }
}

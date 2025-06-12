package com.lesserafim.lesserafimBE.service;

import com.lesserafim.lesserafimBE.api.model.MusicVideo;
import com.lesserafim.lesserafimBE.repository.MusicVideoRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class MusicVideoServiceTest {

    private MusicVideoRepository musicVideoRepository;
    private MusicVideoService musicVideoService;

    @BeforeEach
    public void setUp() {
        musicVideoRepository = mock(MusicVideoRepository.class);

        // Create a sample MV
        MusicVideo sampleMV = new MusicVideo();
        sampleMV.setId(1);
        sampleMV.setTitle("FEARLESS");
        sampleMV.setReleaseDate(new Date());
        sampleMV.setIframeSrc("https://www.youtube.com/watch?v=4vbDFu0PUew");

        when(musicVideoRepository.findAll()).thenReturn(List.of(sampleMV));

        musicVideoService = new MusicVideoService(musicVideoRepository);
    }

    @Test
    public void testGetAllMVs() {
        List<MusicVideo> musicVideos = musicVideoService.getAllMusicVideos();
        assertNotNull(musicVideos);
        assertFalse(musicVideos.isEmpty());
        assertEquals("FEARLESS", musicVideos.get(0).getTitle());
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

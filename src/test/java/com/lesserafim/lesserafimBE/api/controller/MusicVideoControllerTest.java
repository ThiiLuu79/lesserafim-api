package com.lesserafim.lesserafimBE.api.controller;

import com.lesserafim.lesserafimBE.api.model.MusicVideo;
import com.lesserafim.lesserafimBE.service.MusicVideoService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

public class MusicVideoControllerTest {

    @Mock
    private MusicVideoService musicVideoService;

    @InjectMocks
    private MusicVideoController musicVideoController;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testGetAllMVs_ReturnsList() {
        MusicVideo mv1 = new MusicVideo();
        MusicVideo mv2 = new MusicVideo();
        List<MusicVideo> mockList = Arrays.asList(mv1, mv2);

        when(musicVideoService.getAllMusicVideos()).thenReturn(mockList);

        ResponseEntity<?> response = musicVideoController.getAllMusicVideos();

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(mockList, response.getBody());
    }

    @Test
    public void testGetAllMVs_ReturnsNotFound() {
        when(musicVideoService.getAllMusicVideos()).thenReturn(Collections.emptyList());

        ResponseEntity<?> response = musicVideoController.getAllMusicVideos();

        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
        assertEquals("No music videos available.", response.getBody());
    }

    @Test
    public void testGetMVsById_ValidId() {
        int id = 1;
        MusicVideo mv = new MusicVideo();

        when(musicVideoService.getMusicVideoById(id)).thenReturn(mv);

        ResponseEntity<?> response = musicVideoController.getMusicVideoById(id);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(mv, response.getBody());
    }

    @Test
    public void testGetMVById_NotFound() {
        int id = 99;

        when(musicVideoService.getMusicVideoById(id)).thenReturn(null);

        ResponseEntity<?> response = musicVideoController.getMusicVideoById(id);

        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
        assertEquals("No music video found for the given ID.", response.getBody());
    }

    @Test
    public void testGetMVById_NullId() {
        ResponseEntity<?> response = musicVideoController.getMusicVideoById(null);

        assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
        assertEquals("ID parameter cannot be null.", response.getBody());
    }

    @Test
    public void testGetMVById_InternalServerError() {
        int id = 1;
        when(musicVideoService.getMusicVideoById(id)).thenThrow(new RuntimeException("Database error"));

        ResponseEntity<?> response = musicVideoController.getMusicVideoById(id);

        assertEquals(HttpStatus.INTERNAL_SERVER_ERROR, response.getStatusCode());
        assertEquals("An error occurred while processing the request.", response.getBody());
    }
}

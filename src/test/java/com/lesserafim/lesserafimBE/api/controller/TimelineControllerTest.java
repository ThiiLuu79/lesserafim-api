package com.lesserafim.lesserafimBE.api.controller;

import com.lesserafim.lesserafimBE.api.model.Timeline;
import com.lesserafim.lesserafimBE.service.TimelineService;
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

public class TimelineControllerTest {

    @Mock
    private TimelineService timelineService;

    @InjectMocks
    private TimelineController timelineController;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testGetAllTimeline_ReturnsList() {
        Timeline t1 = new Timeline();
        Timeline t2 = new Timeline();
        List<Timeline> mockList = Arrays.asList(t1, t2);

        when(timelineService.getCompleteTimeline()).thenReturn(mockList);

        ResponseEntity<?> response = timelineController.getAllTimeline();

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(mockList, response.getBody());
    }

    @Test
    public void testGetAllTimeline_ReturnsNotFound() {
        when(timelineService.getCompleteTimeline()).thenReturn(Collections.emptyList());

        ResponseEntity<?> response = timelineController.getAllTimeline();

        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
        assertEquals("No timeline available.", response.getBody());
    }

    @Test
    public void testGetTimelineById_ValidId() {
        int id = 1;
        Timeline t = new Timeline();

        when(timelineService.getTimelineById(id)).thenReturn(t);

        ResponseEntity<?> response = timelineController.getTimelineById(id);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(t, response.getBody());
    }

    @Test
    public void testGetTimelineById_NotFound() {
        int id = 99;

        when(timelineService.getTimelineById(id)).thenReturn(null);

        ResponseEntity<?> response = timelineController.getTimelineById(id);

        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
        assertEquals("No timeline item found for the given ID.", response.getBody());
    }

    @Test
    public void testGetTimelineById_NullId() {
        ResponseEntity<?> response = timelineController.getTimelineById(null);

        assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
        assertEquals("ID parameter cannot be null.", response.getBody());
    }

    @Test
    public void testGetTimelineById_InternalServerError() {
        int id = 1;
        when(timelineService.getTimelineById(id)).thenThrow(new RuntimeException("Database error"));

        ResponseEntity<?> response = timelineController.getTimelineById(id);

        assertEquals(HttpStatus.INTERNAL_SERVER_ERROR, response.getStatusCode());
        assertEquals("An error occurred while processing the request.", response.getBody());
    }
}

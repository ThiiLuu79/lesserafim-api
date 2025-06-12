package com.lesserafim.lesserafimBE.service;

import com.lesserafim.lesserafimBE.api.model.Timeline;
import com.lesserafim.lesserafimBE.repository.TimelineRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class TimelineServiceTest {

    private TimelineRepository timelineRepository;
    private TimelineService timelineService;

    @BeforeEach
    public void setUp() {
        timelineRepository = mock(TimelineRepository.class);

        // Create a sample timeline entry
        Timeline sample = new Timeline();
        sample.setId(1);
        sample.setTitle("Debut");
        sample.setDate(new Date());
        sample.setText("LE SSERAFIM debuts with FEARLESS.");

        when(timelineRepository.findAll()).thenReturn(List.of(sample));

        timelineService = new TimelineService(timelineRepository);
    }

    @Test
    public void testGetAllTimeline() {
        List<Timeline> t = timelineService.getCompleteTimeline();
        assertNotNull(t);
        assertFalse(t.isEmpty());
        assertEquals("Debut", t.get(0).getTitle());
    }

    @Test
    public void testGetTimelineById_Found() {
        Timeline t = timelineService.getTimelineById(1);
        assertNotNull(t);
        assertEquals(1, t.getId());
    }

    @Test
    public void testGetTimelineById_NotFound() {
        Timeline t = timelineService.getTimelineById(999);
        assertNull(t);
    }
}

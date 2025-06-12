package com.lesserafim.lesserafimBE.service;

import com.lesserafim.lesserafimBE.api.model.Timeline;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class TimelineServiceTest {

    private TimelineService timelineService;

    @BeforeEach
    public void setUp() {
        timelineService = new TimelineService();
    }

    @Test
    public void testGetAllTimeline() {
        List<Timeline> t = timelineService.getCompleteTimeline();
        assertNotNull(t);
        assertTrue(t.size() >= 1, "Timeline list should not be empty");
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

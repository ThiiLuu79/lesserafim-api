package com.lesserafim.lesserafimBE.service;

import com.lesserafim.lesserafimBE.api.model.Timeline;
import com.lesserafim.lesserafimBE.repository.TimelineRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TimelineService {

    private final TimelineRepository timelineRepository;

    @Autowired
    public TimelineService(TimelineRepository timelineRepository) {
        this.timelineRepository = timelineRepository;
    }

    public List<Timeline> getCompleteTimeline() {
        // Always fetch fresh data
        return timelineRepository.findAll();
    }

    public Timeline getTimelineById(int id) {
        // Find by ID from fresh data
        return timelineRepository.findAll().stream()
                .filter(t -> t.getId() == id)
                .findFirst()
                .orElse(null);
    }
}

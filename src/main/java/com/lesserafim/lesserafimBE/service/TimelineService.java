package com.lesserafim.lesserafimBE.service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.lesserafim.lesserafimBE.api.model.Timeline;
import com.lesserafim.lesserafimBE.repository.TimelineRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

@Service
public class TimelineService {

    private final TimelineRepository timelineRepository;
    private List<Timeline> timeline = new ArrayList<>();

    @Autowired
    public TimelineService(TimelineRepository timelineRepository) {
        this.timelineRepository = timelineRepository;
        loadTimelineFromDatabase();
    }

    private void loadTimelineFromDatabase() {
        try {
            List<Timeline> dbTimeline = timelineRepository.findAll();
            if (!dbTimeline.isEmpty()) {
                timeline = dbTimeline;
                System.out.println("Fetching timeline from MongoDB.");
                return;
            }
            System.out.println("No timeline found in the database.");
        } catch (Exception e) {
            System.out.println("Failed to load timeline from database: " + e.getMessage());
        }
    }

    private void loadTimelineFromJson() {
        ObjectMapper objectMapper = new ObjectMapper();
        try (InputStream inputStream = getClass().getClassLoader().getResourceAsStream("timelineData.json")) {
            if (inputStream != null) {
                timeline = objectMapper.readValue(inputStream, new TypeReference<List<Timeline>>() {});
            } else {
                throw new RuntimeException("timelineData.json not found in resources.");
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Failed to load timeline from JSON file.");
        }
    }

    public List<Timeline> getCompleteTimeline() {
        return timeline;
    }

    public Timeline getTimelineById(int id) {
        return timeline.stream()
                .filter(t -> t.getId() == id)
                .findFirst()
                .orElse(null);
    }
}

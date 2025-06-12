package com.lesserafim.lesserafimBE.api.controller;

import com.lesserafim.lesserafimBE.api.model.Timeline;
import com.lesserafim.lesserafimBE.service.TimelineService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/timeline")
@Tag(name = "Timeline", description = "Endpoints to get LE SSERAFIM Timeline.")
public class TimelineController {

    private final TimelineService timelineService;

    public TimelineController(TimelineService timelineService) {
        this.timelineService = timelineService;
    }

    @CrossOrigin(origins = {"http://localhost:3000", "https://lesserafim-page.netlify.app/"})
    @Operation(
            summary = "Get LE SSERAFIM complete timeline.",
            description = "Retrieve LE SSERAFIM complete timeline."
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Timeline retrieved successfully"),
    })
    @GetMapping
    public List<Timeline> getAllTimeline() {
        return timelineService.getCompleteTimeline();
    }

    @CrossOrigin(origins = {"http://localhost:3000", "https://lesserafim-page.netlify.app/"})
    @Operation(
            summary = "Get LE SSERAFIM timeline item.",
            description = "Retrieve LE SSERAFIM timeline item by id."
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Timeline item retrieved successfully"),
    })
    @GetMapping("/{id}")
    public Timeline getTimelineById(
            @Parameter(description = "The ID of the timeline item to retrieve", example = "1")
            @PathVariable int id) {
        return timelineService.getTimelineById(id);
    }

}

package com.lesserafim.lesserafimBE.api.controller;

import com.lesserafim.lesserafimBE.api.model.Timeline;
import com.lesserafim.lesserafimBE.service.TimelineService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/timeline")
@Tag(name = "Timeline", description = "Endpoints to get LE SSERAFIM Timeline.")
public class TimelineController {

    private static final Logger logger = LoggerFactory.getLogger(TimelineController.class);

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
            @ApiResponse(responseCode = "404", description = "No timeline found"),
    })
    @GetMapping
    public ResponseEntity<?> getAllTimeline() {
        logger.info("GET /api/timeline - Fetching complete timeline");

        List<Timeline> timeline = timelineService.getCompleteTimeline();

        if (timeline.isEmpty()) {
            logger.warn("GET /api/timeline - No timeline data found (404)");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No timeline available.");
        }

        logger.info("GET /api/timeline - Retrieved {} timeline items", timeline.size());
        return ResponseEntity.ok(timeline);
    }

    @CrossOrigin(origins = {"http://localhost:3000", "https://lesserafim-page.netlify.app/"})
    @Operation(
            summary = "Get LE SSERAFIM timeline item.",
            description = "Retrieve LE SSERAFIM timeline item by id."
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Timeline item retrieved successfully"),
            @ApiResponse(responseCode = "400", description = "Invalid ID parameter"),
            @ApiResponse(responseCode = "404", description = "No timeline item found for the given ID"),
            @ApiResponse(responseCode = "500", description = "Internal server error")
    })
    @GetMapping("/{id}")
    public ResponseEntity<?> getTimelineById(
            @Parameter(description = "The ID of the timeline item to retrieve", example = "1")
            @PathVariable Integer id) {

        logger.info("GET /api/timeline/{} - Request to fetch timeline item", id);

        try {
            if (id == null) {
                logger.error("GET /api/timeline - ID parameter is null (400)");
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("ID parameter cannot be null.");
            }

            Timeline timelineItem = timelineService.getTimelineById(id);

            if (timelineItem == null) {
                logger.warn("GET /api/timeline/{} - No timeline item found (404)", id);
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No timeline item found for the given ID.");
            }

            logger.info("GET /api/timeline/{} - Successfully retrieved timeline item", id);
            return ResponseEntity.ok(timelineItem);

        } catch (Exception e) {
            logger.error("GET /api/timeline/{} - Internal server error (500): {}", id, e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("An error occurred while processing the request.");
        }
    }
}

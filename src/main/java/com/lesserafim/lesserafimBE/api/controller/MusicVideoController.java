package com.lesserafim.lesserafimBE.api.controller;

import com.lesserafim.lesserafimBE.api.model.MusicVideo;
import com.lesserafim.lesserafimBE.service.MusicVideoService;
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
@RequestMapping("/api/musicVideos")
@Tag(name = "Music Videos", description = "Endpoints to get LE SSERAFIM MVs.")
public class MusicVideoController {

    private static final Logger logger = LoggerFactory.getLogger(MusicVideoController.class);

    private final MusicVideoService musicVideoService;

    public MusicVideoController(MusicVideoService musicVideoService) {
        this.musicVideoService = musicVideoService;
    }

    @CrossOrigin(origins = {"http://localhost:3000", "https://lesserafim-page.netlify.app/"})
    @Operation(
            summary = "Get all LE SSERAFIM MVs.",
            description = "Retrieve all LE SSERAFIM Music Videos."
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Music videos retrieved successfully"),
            @ApiResponse(responseCode = "404", description = "No music videos found"),
    })
    @GetMapping
    public ResponseEntity<?> getAllMusicVideos() {
        logger.info("GET /api/musicVideos - Request to fetch all music videos");

        List<MusicVideo> allMusicVideos = musicVideoService.getAllMusicVideos();

        if (allMusicVideos.isEmpty()) {
            logger.warn("GET /api/musicVideos - No music videos found (404)");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No music videos available.");
        }

        logger.info("GET /api/musicVideos - Successfully retrieved {} music videos", allMusicVideos.size());
        return ResponseEntity.ok(allMusicVideos);
    }

    @CrossOrigin(origins = {"http://localhost:3000", "https://lesserafim-page.netlify.app/"})
    @Operation(
            summary = "Get a LE SSERAFIM music video.",
            description = "Retrieve a LE SSERAFIM music video by its ID."
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Music video retrieved successfully"),
            @ApiResponse(responseCode = "400", description = "Invalid ID parameter"),
            @ApiResponse(responseCode = "404", description = "No music video found for the given ID"),
            @ApiResponse(responseCode = "500", description = "Internal server error")
    })
    @GetMapping("/{id}")
    public ResponseEntity<?> getMusicVideoById(
            @Parameter(description = "The ID of the MV to retrieve", example = "1")
            @PathVariable Integer id) {

        logger.info("GET /api/musicVideos/{} - Request received", id);

        try {
            if (id == null) {
                logger.error("GET /api/musicVideos - ID parameter is null (400)");
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("ID parameter cannot be null.");
            }

            MusicVideo musicVideo = musicVideoService.getMusicVideoById(id);

            if (musicVideo == null) {
                logger.warn("GET /api/musicVideos/{} - No music video found (404)", id);
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No music video found for the given ID.");
            }

            logger.info("GET /api/musicVideos/{} - Successfully retrieved music video", id);
            return ResponseEntity.ok(musicVideo);

        } catch (Exception e) {
            logger.error("GET /api/musicVideos/{} - Internal server error (500): {}", id, e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("An error occurred while processing the request.");
        }
    }
}

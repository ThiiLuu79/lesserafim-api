package com.lesserafim.lesserafimBE.api.controller;

import com.lesserafim.lesserafimBE.api.model.MusicVideo;
import com.lesserafim.lesserafimBE.service.MusicVideoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/musicVideos")
@Tag(name = "Music Videos", description = "Endpoints to get LE SSERAFIM MVs.")
public class MusicVideoController {
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
    })
    @GetMapping
    public List<MusicVideo> getAllMusicVideos() {
        return musicVideoService.getAllMusicVideos();
    }

    @CrossOrigin(origins = {"http://localhost:3000", "https://lesserafim-page.netlify.app/"})
    @Operation(
            summary = "Get a LE SSERAFIM music video.",
            description = "Retrieve a LE SSERAFIM music video by it's id."
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Music video retrieved successfully"),
    })
    @GetMapping("/{id}")
    public MusicVideo getMusicVideoById(
            @Parameter(description = "The ID of the MV to retrieve", example = "1")
            @PathVariable int id) {
        return musicVideoService.getMusicVideoById(id);
    }
}

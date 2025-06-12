package com.lesserafim.lesserafimBE.api.controller;

import com.lesserafim.lesserafimBE.api.model.Discography;
import com.lesserafim.lesserafimBE.service.DiscographyService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/discographies")
@Tag(name = "Discographies", description = "Endpoints to get LE SSERAFIM discographies.")
public class DiscographyController {
    private final DiscographyService discographyService;

    public DiscographyController(DiscographyService discographyService){this.discographyService = discographyService;}

    @CrossOrigin(origins = {"http://localhost:3000", "https://lesserafim-page.netlify.app/"})
    @Operation(
            summary = "Get all discographies items.",
            description = "Retrieve all discographies items from LE SSERAFIM."
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Discographies retrieved successfully"),
    })
    @GetMapping
    public List<Discography> getAllDiscographies() {
        return discographyService.getAllDiscographies();
    }

    @CrossOrigin(origins = {"http://localhost:3000", "https://lesserafim-page.netlify.app/"})
    @Operation(
            summary = "Get a discography item by id.",
            description = "Retrieve a discography items by a specific id."
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Discography retrieved successfully"),
    })
    @GetMapping("/{id}")
    public Discography getDiscographyById(
            @Parameter(description = "The ID of the discography to retrieve", example = "1")
            @PathVariable int id) {
        return discographyService.getDiscographyById(id);
    }
}

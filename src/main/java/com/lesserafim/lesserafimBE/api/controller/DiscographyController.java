package com.lesserafim.lesserafimBE.api.controller;

import com.lesserafim.lesserafimBE.api.model.Discography;
import com.lesserafim.lesserafimBE.service.DiscographyService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
            @ApiResponse(responseCode = "404", description = "No discographies found"),
    })
    @GetMapping
    public ResponseEntity<?> getAllDiscographies() {
        List<Discography> allDiscographies = discographyService.getAllDiscographies();

        if(allDiscographies.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No discographies available.");
        }

        return ResponseEntity.ok(allDiscographies);
    }

    @CrossOrigin(origins = {"http://localhost:3000", "https://lesserafim-page.netlify.app/"})
    @Operation(
            summary = "Get a discography item by id.",
            description = "Retrieve a discography items by a specific id."
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Discography retrieved successfully"),
            @ApiResponse(responseCode = "400", description = "Invalid ID parameter"),
            @ApiResponse(responseCode = "404", description = "No discography found for the given ID"),
            @ApiResponse(responseCode = "500", description = "Internal server error")
    })
    @GetMapping("/{id}")
    public ResponseEntity<?> getDiscographyById(
            @Parameter(description = "The ID of the discography to retrieve", example = "1")
            @PathVariable Integer id) {
        try {
            if (id == null) {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("ID parameter cannot be null.");
            }

            Discography discography = discographyService.getDiscographyById(id);
            if (discography == null) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No discography found for the given ID.");
            }

            return ResponseEntity.ok(discography);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("An error occurred while processing the request.");
        }
    }
}

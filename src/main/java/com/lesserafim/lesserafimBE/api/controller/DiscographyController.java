package com.lesserafim.lesserafimBE.api.controller;

import com.lesserafim.lesserafimBE.api.model.Discography;
import com.lesserafim.lesserafimBE.service.DiscographyService;
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
@RequestMapping("/api/discographies")
@Tag(name = "Discographies", description = "Endpoints to get LE SSERAFIM discographies.")
public class DiscographyController {

    private static final Logger logger = LoggerFactory.getLogger(DiscographyController.class);

    private final DiscographyService discographyService;

    public DiscographyController(DiscographyService discographyService) {
        this.discographyService = discographyService;
    }

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
        logger.info("GET /api/discographies - Fetching all discographies");

        List<Discography> allDiscographies = discographyService.getAllDiscographies();

        if (allDiscographies.isEmpty()) {
            logger.warn("GET /api/discographies - No discographies found (404)");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No discographies available.");
        }

        logger.info("GET /api/discographies - Successfully retrieved {} discographies", allDiscographies.size());
        return ResponseEntity.ok(allDiscographies);
    }

    @CrossOrigin(origins = {"http://localhost:3000", "https://lesserafim-page.netlify.app/"})
    @Operation(
            summary = "Get a discography item by id.",
            description = "Retrieve a discography item by a specific id."
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

        logger.info("GET /api/discographies/{} - Request received", id);

        try {
            if (id == null) {
                logger.error("GET /api/discographies - ID parameter is null (400)");
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("ID parameter cannot be null.");
            }

            Discography discography = discographyService.getDiscographyById(id);

            if (discography == null) {
                logger.warn("GET /api/discographies/{} - No discography found (404)", id);
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No discography found for the given ID.");
            }

            logger.info("GET /api/discographies/{} - Successfully retrieved discography (200)", id);
            return ResponseEntity.ok(discography);

        } catch (Exception e) {
            logger.error("GET /api/discographies/{} - Internal server error (500): {}", id, e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("An error occurred while processing the request.");
        }
    }
}

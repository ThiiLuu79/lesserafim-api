package com.lesserafim.lesserafimBE.api.controller;

import com.lesserafim.lesserafimBE.api.model.Member;
import com.lesserafim.lesserafimBE.service.MemberService;
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
@RequestMapping("/api/members")
@Tag(name = "Members", description = "Endpoints to get LE SSERAFIM members.")
public class MemberController {

    private static final Logger logger = LoggerFactory.getLogger(MemberController.class);

    private final MemberService memberService;

    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    @CrossOrigin(origins = {"http://localhost:3000", "https://lesserafim-page.netlify.app/"})
    @Operation(
            summary = "Get all LE SSERAFIM members.",
            description = "Retrieve all LE SSERAFIM members."
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Members retrieved successfully"),
            @ApiResponse(responseCode = "404", description = "No members found"),
    })
    @GetMapping
    public ResponseEntity<?> getAllMembers() {
        logger.info("GET /api/members - Request to fetch all members");

        List<Member> allMember = memberService.getAllMembers();

        if (allMember.isEmpty()) {
            logger.warn("GET /api/members - No members found (404)");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No members found.");
        }

        logger.info("GET /api/members - Successfully retrieved {} members", allMember.size());
        return ResponseEntity.ok(allMember);
    }

    @CrossOrigin(origins = {"http://localhost:3000", "https://lesserafim-page.netlify.app/"})
    @Operation(
            summary = "Get LE SSERAFIM member by id.",
            description = "Retrieve LE SSERAFIM member by their id."
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Member retrieved successfully"),
            @ApiResponse(responseCode = "400", description = "Invalid ID parameter"),
            @ApiResponse(responseCode = "404", description = "No member found for the given ID"),
            @ApiResponse(responseCode = "500", description = "Internal server error")
    })
    @GetMapping("/{id}")
    public ResponseEntity<?> getMemberById(
            @Parameter(description = "The ID of the member to retrieve", example = "1")
            @PathVariable Integer id) {

        logger.info("GET /api/members/{} - Request received", id);

        try {
            if (id == null) {
                logger.error("GET /api/members - ID parameter is null (400)");
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("ID parameter cannot be null.");
            }

            Member member = memberService.getMemberById(id);

            if (member == null) {
                logger.warn("GET /api/members/{} - No member found (404)", id);
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No member found for the given ID.");
            }

            logger.info("GET /api/members/{} - Successfully retrieved member", id);
            return ResponseEntity.ok(member);

        } catch (Exception e) {
            logger.error("GET /api/members/{} - Internal server error (500): {}", id, e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("An error occurred while processing the request.");
        }
    }
}

package com.lesserafim.lesserafimBE.api.controller;

import com.lesserafim.lesserafimBE.api.model.Member;
import com.lesserafim.lesserafimBE.service.MemberService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/members")
@Tag(name = "Members", description = "Endpoints to get LE SSERAFIM members.")
public class MemberController {

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
    })
    @GetMapping
    public List<Member> getAllMembers() {
        return memberService.getAllMembers();
    }

    @CrossOrigin(origins = {"http://localhost:3000", "https://lesserafim-page.netlify.app/"})
    @Operation(
            summary = "Get LE SSERAFIM member by id.",
            description = "Retrieve LE SSERAFIM member by their id."
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Member retrieved successfully"),
    })
    @GetMapping("/{id}")
    public Member getMemberById(
            @Parameter(description = "The ID of the member to retrieve", example = "1")
            @PathVariable int id) {
        return memberService.getMemberById(id);
    }
}

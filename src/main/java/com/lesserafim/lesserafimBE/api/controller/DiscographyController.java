package com.lesserafim.lesserafimBE.api.controller;

import com.lesserafim.lesserafimBE.api.model.Discography;
import com.lesserafim.lesserafimBE.service.DiscographyService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/discographies")
public class DiscographyController {
    private final DiscographyService discographyService;

    public DiscographyController(DiscographyService discographyService){this.discographyService = discographyService;}

    @GetMapping
    public List<Discography> getAllDiscographies() {
        return discographyService.getAllDiscographies();
    }

    @GetMapping("/{id}")
    public Discography getDiscographyById(@PathVariable int id) {
        return discographyService.getDiscographyById(id);
    }
}

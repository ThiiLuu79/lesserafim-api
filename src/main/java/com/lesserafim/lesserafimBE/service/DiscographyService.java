package com.lesserafim.lesserafimBE.service;

import com.lesserafim.lesserafimBE.api.model.Discography;
import com.lesserafim.lesserafimBE.repository.DiscographyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DiscographyService {

    private final DiscographyRepository discographyRepository;

    @Autowired
    public DiscographyService(DiscographyRepository discographyRepository) {
        this.discographyRepository = discographyRepository;
    }

    public List<Discography> getAllDiscographies() {
        // Always fetch fresh data from MongoDB
        return discographyRepository.findAll();
    }

    public Discography getDiscographyById(int id) {
        // Also fetches fresh data every time
        return discographyRepository.findAll().stream()
                .filter(discography -> discography.getId() == id)
                .findFirst()
                .orElse(null);
    }

}

package com.lesserafim.lesserafimBE.service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.lesserafim.lesserafimBE.api.model.Discography;
import com.lesserafim.lesserafimBE.repository.DiscographyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

@Service
public class DiscographyService {

    private final DiscographyRepository discographyRepository;
    private List<Discography> discographies = new ArrayList<>();

    @Autowired
    public DiscographyService(DiscographyRepository discographyRepository) {
        this.discographyRepository = discographyRepository;
        loadDiscographyFromDatabase();
    }

    private void loadDiscographyFromDatabase() {
        try {
            List<Discography> dbDiscographies = discographyRepository.findAll();
            if (!dbDiscographies.isEmpty()) {
                discographies = dbDiscographies;
                System.out.println("Fetching discographies from MongoDB.");
                return;
            }
            System.out.println("No discographies found in the database.");
        } catch (Exception e) {
            System.out.println("Failed to load discographies from database: " + e.getMessage());
        }
    }

    private void loadDiscographyFromJson() {
        ObjectMapper objectMapper = new ObjectMapper();
        try (InputStream inputStream = getClass().getClassLoader().getResourceAsStream("discographyData.json")) {
            if (inputStream != null) {
                discographies = objectMapper.readValue(inputStream, new TypeReference<List<Discography>>() {});
            } else {
                throw new RuntimeException("discographyData.json not found in resources.");
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Failed to load discographies from JSON file.");
        }
    }

    public List<Discography> getAllDiscographies() {
        return discographies;
    }

    public Discography getDiscographyById(int id) {
        return discographies.stream()
                .filter(discography -> discography.getId() == id)
                .findFirst()
                .orElse(null);
    }

}

package com.lesserafim.lesserafimBE.service;

import com.lesserafim.lesserafimBE.api.model.Discography;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class DiscographyServiceTest {

    private DiscographyService discographyService;

    @BeforeEach
    public void setUp() {
        discographyService = new DiscographyService();
    }

    @Test
    public void testGetAllDiscographies() {
        List<Discography> discographies = discographyService.getAllDiscographies();
        assertNotNull(discographies);
        assertTrue(discographies.size() >= 1, "Discography list should not be empty");
    }

    @Test
    public void testGetDiscographyById_Found() {
        Discography discography = discographyService.getDiscographyById(1);
        assertNotNull(discography);
        assertEquals(1, discography.getId());
        assertEquals("FEARLESS", discography.getTitle());
    }

    @Test
    public void testGetDiscographyById_NotFound() {
        Discography discography = discographyService.getDiscographyById(999);
        assertNull(discography);
    }
}

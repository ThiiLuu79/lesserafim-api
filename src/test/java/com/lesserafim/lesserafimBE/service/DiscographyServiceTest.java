package com.lesserafim.lesserafimBE.service;

import com.lesserafim.lesserafimBE.api.model.Discography;
import com.lesserafim.lesserafimBE.repository.DiscographyRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class DiscographyServiceTest {

    private DiscographyRepository discographyRepository;
    private DiscographyService discographyService;

    @BeforeEach
    public void setUp() {
        discographyRepository = mock(DiscographyRepository.class);

        // Sample discography list
        Discography sample = new Discography();
        sample.setId(1);
        sample.setTitle("FEARLESS");
        sample.setReleaseDate(new Date());
        sample.setSongs(Arrays.asList("The World Is My Oyster", "FEARLESS"));

        when(discographyRepository.findAll()).thenReturn(List.of(sample));

        discographyService = new DiscographyService(discographyRepository);
    }

    @Test
    public void testGetAllDiscographies() {
        List<Discography> discographies = discographyService.getAllDiscographies();
        assertNotNull(discographies);
        assertFalse(discographies.isEmpty());
        assertEquals("FEARLESS", discographies.get(0).getTitle());
    }

    @Test
    public void testGetDiscographyById_Found() {
        Discography result = discographyService.getDiscographyById(1);
        assertNotNull(result);
        assertEquals(1, result.getId());
    }

    @Test
    public void testGetDiscographyById_NotFound() {
        Discography result = discographyService.getDiscographyById(999);
        assertNull(result);
    }
}

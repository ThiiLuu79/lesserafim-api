package com.lesserafim.lesserafimBE.api.controller;

import com.lesserafim.lesserafimBE.api.model.Discography;
import com.lesserafim.lesserafimBE.service.DiscographyService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

public class DiscographyControllerTest {

    @Mock
    private DiscographyService discographyService;

    @InjectMocks
    private DiscographyController discographyController;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testGetAllDiscographies_ReturnsList() {
        Discography disc1 = new Discography();
        Discography disc2 = new Discography();
        List<Discography> mockList = Arrays.asList(disc1, disc2);

        when(discographyService.getAllDiscographies()).thenReturn(mockList);

        ResponseEntity<?> response = discographyController.getAllDiscographies();

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(mockList, response.getBody());
    }

    @Test
    public void testGetAllDiscographies_ReturnsNotFound() {
        when(discographyService.getAllDiscographies()).thenReturn(Collections.emptyList());

        ResponseEntity<?> response = discographyController.getAllDiscographies();

        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
        assertEquals("No discographies available.", response.getBody());
    }

    @Test
    public void testGetDiscographyById_ValidId() {
        int id = 1;
        Discography disc = new Discography();

        when(discographyService.getDiscographyById(id)).thenReturn(disc);

        ResponseEntity<?> response = discographyController.getDiscographyById(id);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(disc, response.getBody());
    }

    @Test
    public void testGetDiscographyById_NotFound() {
        int id = 99;

        when(discographyService.getDiscographyById(id)).thenReturn(null);

        ResponseEntity<?> response = discographyController.getDiscographyById(id);

        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
        assertEquals("No discography found for the given ID.", response.getBody());
    }

    @Test
    public void testGetDiscographyById_NullId() {
        ResponseEntity<?> response = discographyController.getDiscographyById(null);

        assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
        assertEquals("ID parameter cannot be null.", response.getBody());
    }

    @Test
    public void testGetDiscographyById_InternalServerError() {
        int id = 1;
        when(discographyService.getDiscographyById(id)).thenThrow(new RuntimeException("Database error"));

        ResponseEntity<?> response = discographyController.getDiscographyById(id);

        assertEquals(HttpStatus.INTERNAL_SERVER_ERROR, response.getStatusCode());
        assertEquals("An error occurred while processing the request.", response.getBody());
    }
}

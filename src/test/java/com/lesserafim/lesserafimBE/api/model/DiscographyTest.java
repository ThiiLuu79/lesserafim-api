package com.lesserafim.lesserafimBE.api.model;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Date;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class DiscographyTest {
    @Test
    public void testGettersAndSetters() {
        Discography discography = new Discography();
        discography.setId(1);
        discography.setTitle("FEARLESS");
        discography.setType("1st album");
        discography.setReleaseDate(new Date(1672531200000L));
        List<String> songs = Arrays.asList("FEARLESS", "Sour Grapes", "The Great Mermaid");
        discography.setSongs(songs);
        discography.setImageURL("imageURL");


        assertEquals(1, discography.getId());
        assertEquals("FEARLESS", discography.getTitle());
        assertEquals("1st album", discography.getType());
        assertEquals(new Date(1672531200000L), discography.getReleaseDate());
        assertEquals(songs, discography.getSongs());
        assertEquals("imageURL", discography.getImageURL());
    }

    @Test
    public void testConstructorWithParameters() {
        List<String> songs = Arrays.asList("FEARLESS", "Sour Grapes", "The Great Mermaid");

        Discography discography = new Discography(1, "FEARLESS", "1st album", new Date(1672531200000L), songs, "imageURL");

        assertEquals(1, discography.getId());
        assertEquals("FEARLESS", discography.getTitle());
        assertEquals("1st album", discography.getType());
        assertEquals(new Date(1672531200000L), discography.getReleaseDate());
        assertEquals(songs, discography.getSongs());
        assertEquals("imageURL", discography.getImageURL());
    }
}

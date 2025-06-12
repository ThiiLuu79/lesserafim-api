package com.lesserafim.lesserafimBE.api.model;

import org.junit.jupiter.api.Test;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MusicVideoTest {

    @Test
    public void testGettersAndSetters() {
        MusicVideo musicVideo = new MusicVideo();
        Date releaseDate = new Date(1651363200000L); // 2022-05-01

        musicVideo.setId(1);
        musicVideo.setTitle("FEARLESS");
        musicVideo.setIframeSrc("https://www.youtube.com/embed/4vbDFu0PUew");
        musicVideo.setReleaseDate(releaseDate);

        assertEquals(1, musicVideo.getId());
        assertEquals("FEARLESS", musicVideo.getTitle());
        assertEquals("https://www.youtube.com/embed/4vbDFu0PUew", musicVideo.getIframeSrc());
        assertEquals(releaseDate, musicVideo.getReleaseDate());
    }

    @Test
    public void testConstructorWithParameters() {
        Date releaseDate = new Date(1651363200000L); // 2022-05-01

        MusicVideo musicVideo = new MusicVideo(
                1,
                "FEARLESS",
                "https://www.youtube.com/embed/4vbDFu0PUew",
                releaseDate
        );

        assertEquals(1, musicVideo.getId());
        assertEquals("FEARLESS", musicVideo.getTitle());
        assertEquals("https://www.youtube.com/embed/4vbDFu0PUew", musicVideo.getIframeSrc());
        assertEquals(releaseDate, musicVideo.getReleaseDate());
    }
}

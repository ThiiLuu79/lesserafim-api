package com.lesserafim.lesserafimBE.api.model;

import org.junit.jupiter.api.Test;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TimelineTest {

    @Test
    public void testGettersAndSetters() {
        Timeline timeline = new Timeline();
        Date date = new Date(1651363200000L); // 2022-05-01

        timeline.setId(1);
        timeline.setTitle("Debut");
        timeline.setImageURL("https://example.com/debut.jpg");
        timeline.setDate(date);
        timeline.setText("LE SSERAFIM officially debuted with their first EP 'FEARLESS'.");

        assertEquals(1, timeline.getId());
        assertEquals("Debut", timeline.getTitle());
        assertEquals("https://example.com/debut.jpg", timeline.getImageURL());
        assertEquals(date, timeline.getDate());
        assertEquals("LE SSERAFIM officially debuted with their first EP 'FEARLESS'.", timeline.getText());
    }

    @Test
    public void testConstructorWithParameters() {
        Date date = new Date(1651363200000L); // 2022-05-01

        Timeline timeline = new Timeline(
                1,
                "Debut",
                "https://example.com/debut.jpg",
                date,
                "LE SSERAFIM officially debuted with their first EP 'FEARLESS'."
        );

        assertEquals(1, timeline.getId());
        assertEquals("Debut", timeline.getTitle());
        assertEquals("https://example.com/debut.jpg", timeline.getImageURL());
        assertEquals(date, timeline.getDate());
        assertEquals("LE SSERAFIM officially debuted with their first EP 'FEARLESS'.", timeline.getText());
    }
}

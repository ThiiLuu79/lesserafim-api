package com.lesserafim.lesserafimBE.api.model;

import java.util.Date;
import java.util.List;

public class Discography {
    private int id;
    private String title;
    private String type;
    private Date releaseDate;
    private List<String> songs;
    private String imageURL;

    public Discography() {
    }

    public Discography(int id, String title, String type, Date releaseDate, List<String> songs, String imageURL) {
        this.id = id;
        this.title = title;
        this.type = type;
        this.releaseDate = releaseDate;
        this.songs = songs;
        this.imageURL = imageURL;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Date getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(Date releaseDate) {
        this.releaseDate = releaseDate;
    }

    public List<String> getSongs() {
        return songs;
    }

    public void setSongs(List<String> songs) {
        this.songs = songs;
    }

    public String getImageURL() {
        return imageURL;
    }

    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }
}

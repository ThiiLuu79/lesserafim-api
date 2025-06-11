package com.lesserafim.lesserafimBE.api.model;

import java.util.Date;

public class Timeline {
    private int id;
    private String title;
    private String imageURL;
    private Date date;
    private String text;

    public Timeline() {
    }

    public Timeline(int id, String title, String imageURL, Date date, String text) {
        this.id = id;
        this.title = title;
        this.imageURL = imageURL;
        this.date = date;
        this.text = text;
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

    public String getImageURL() {
        return imageURL;
    }

    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}

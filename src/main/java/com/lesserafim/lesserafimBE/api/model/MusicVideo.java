package com.lesserafim.lesserafimBE.api.model;

import java.util.Date;

public class MusicVideo {
    private int id;
    private String title;
    private String iframeSrc;
    private Date releaseDate;

    public MusicVideo() {
    }

    public MusicVideo(int id, String title, String iframeSrc, Date releaseDate) {
        this.id = id;
        this.title = title;
        this.iframeSrc = iframeSrc;
        this.releaseDate = releaseDate;
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

    public String getIframeSrc() {
        return iframeSrc;
    }

    public void setIframeSrc(String iframeSrc) {
        this.iframeSrc = iframeSrc;
    }
    public Date getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(Date releaseDate) {
        this.releaseDate = releaseDate;
    }
}

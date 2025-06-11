package com.lesserafim.lesserafimBE.api.model;

public class MusicVideo {
    private int id;
    private String title;
    private String iframeSrc;

    public MusicVideo() {
    }

    public MusicVideo(int id, String title, String iframeSrc) {
        this.id = id;
        this.title = title;
        this.iframeSrc = iframeSrc;
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
}

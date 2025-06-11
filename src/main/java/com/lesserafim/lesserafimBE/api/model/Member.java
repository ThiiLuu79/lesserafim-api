package com.lesserafim.lesserafimBE.api.model;

import java.util.Date;

public class Member {
    private int id;
    private String name;
    private String birthname;
    private String image1URL;
    private String image2URL;
    private String description;
    private Date birthday;
    private String position;
    private String nationality;
    private String instagram;
    private float height;
    private float weight;
    private String bloodtype;
    private String mbti;
    private String zodiac;
    private String chineseZodiac;

    // Constructor
    public Member() {
    }

    public Member(int id, String name, String birthname, String image1URL, String image2URL, String description, Date birthday, String position, String nationality, String instagram, float height, float weight, String bloodtype, String mbti, String zodiac, String chineseZodiac) {
        this.id = id;
        this.name = name;
        this.birthname = birthname;
        this.image1URL = image1URL;
        this.image2URL = image2URL;
        this.description = description;
        this.birthday = birthday;
        this.position = position;
        this.nationality = nationality;
        this.instagram = instagram;
        this.height = height;
        this.weight = weight;
        this.bloodtype = bloodtype;
        this.mbti = mbti;
        this.zodiac = zodiac;
        this.chineseZodiac = chineseZodiac;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBirthname() {
        return birthname;
    }

    public void setBirthname(String birthname) {
        this.birthname = birthname;
    }

    public String getImage1URL() {
        return image1URL;
    }

    public void setImage1URL(String image1URL) {
        this.image1URL = image1URL;
    }

    public String getImage2URL() {
        return image2URL;
    }

    public void setImage2URL(String image2URL) {
        this.image2URL = image2URL;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public String getInstagram() {
        return instagram;
    }

    public void setInstagram(String instagram) {
        this.instagram = instagram;
    }

    public float getHeight() {
        return height;
    }

    public void setHeight(float height) {
        this.height = height;
    }

    public float getWeight() {
        return weight;
    }

    public void setWeight(float weight) {
        this.weight = weight;
    }

    public String getBloodtype() {
        return bloodtype;
    }

    public void setBloodtype(String bloodtype) {
        this.bloodtype = bloodtype;
    }

    public String getMbti() {
        return mbti;
    }

    public void setMbti(String mbti) {
        this.mbti = mbti;
    }

    public String getZodiac() {
        return zodiac;
    }

    public void setZodiac(String zodiac) {
        this.zodiac = zodiac;
    }

    public String getChineseZodiac() {
        return chineseZodiac;
    }

    public void setChineseZodiac(String chineseZodiac) {
        this.chineseZodiac = chineseZodiac;
    }
}

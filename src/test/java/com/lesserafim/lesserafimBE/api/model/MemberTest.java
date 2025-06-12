package com.lesserafim.lesserafimBE.api.model;

import org.junit.jupiter.api.Test;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MemberTest {

    @Test
    public void testGettersAndSetters() {
        Member member = new Member();
        Date birthday = new Date(946684800000L); // 2000-01-01

        member.setId(1);
        member.setName("Kim Chaewon");
        member.setBirthname("Kim Chaewon");
        member.setImage1URL("url1");
        member.setImage2URL("url2");
        member.setDescription("Leader of LE SSERAFIM");
        member.setBirthday(birthday);
        member.setPosition("Leader, Vocalist");
        member.setNationality("Korean");
        member.setInstagram("@chaewon");
        member.setHeight(1.62f);
        member.setWeight(42.0f);
        member.setBloodtype("B");
        member.setMbti("ISFP");
        member.setZodiac("Pisces");
        member.setChineseZodiac("Dragon");

        assertEquals(1, member.getId());
        assertEquals("Kim Chaewon", member.getName());
        assertEquals("Kim Chaewon", member.getBirthname());
        assertEquals("url1", member.getImage1URL());
        assertEquals("url2", member.getImage2URL());
        assertEquals("Leader of LE SSERAFIM", member.getDescription());
        assertEquals(birthday, member.getBirthday());
        assertEquals("Leader, Vocalist", member.getPosition());
        assertEquals("Korean", member.getNationality());
        assertEquals("@chaewon", member.getInstagram());
        assertEquals(1.62f, member.getHeight());
        assertEquals(42.0f, member.getWeight());
        assertEquals("B", member.getBloodtype());
        assertEquals("ISFP", member.getMbti());
        assertEquals("Pisces", member.getZodiac());
        assertEquals("Dragon", member.getChineseZodiac());
    }

    @Test
    public void testConstructorWithParameters() {
        Date birthday = new Date(946684800000L); // 2000-01-01

        Member member = new Member(
                1,
                "Kim Chaewon",
                "Kim Chaewon",
                "url1",
                "url2",
                "Leader of LE SSERAFIM",
                birthday,
                "Leader, Vocalist",
                "Korean",
                "@chaewon",
                1.62f,
                42.0f,
                "B",
                "ISFP",
                "Pisces",
                "Dragon"
        );

        assertEquals(1, member.getId());
        assertEquals("Kim Chaewon", member.getName());
        assertEquals("Kim Chaewon", member.getBirthname());
        assertEquals("url1", member.getImage1URL());
        assertEquals("url2", member.getImage2URL());
        assertEquals("Leader of LE SSERAFIM", member.getDescription());
        assertEquals(birthday, member.getBirthday());
        assertEquals("Leader, Vocalist", member.getPosition());
        assertEquals("Korean", member.getNationality());
        assertEquals("@chaewon", member.getInstagram());
        assertEquals(1.62f, member.getHeight());
        assertEquals(42.0f, member.getWeight());
        assertEquals("B", member.getBloodtype());
        assertEquals("ISFP", member.getMbti());
        assertEquals("Pisces", member.getZodiac());
        assertEquals("Dragon", member.getChineseZodiac());
    }
}

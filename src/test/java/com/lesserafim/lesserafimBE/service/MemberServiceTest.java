package com.lesserafim.lesserafimBE.service;

import com.lesserafim.lesserafimBE.api.model.Member;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class MemberServiceTest {

    private MemberService memberService;

    @BeforeEach
    public void setUp() {
        memberService = new MemberService();
    }

    @Test
    public void testGetAllMembers() {
        List<Member> discographies = memberService.getAllMembers();
        assertNotNull(discographies);
        assertTrue(discographies.size() >= 1, "Members list should not be empty");
    }

    @Test
    public void testGetMemberById_Found() {
        Member member = memberService.getMemberById(1);
        assertNotNull(member);
        assertEquals(1, member.getId());
    }

    @Test
    public void testGetMemberById_NotFound() {
        Member member = memberService.getMemberById(999);
        assertNull(member);
    }
}

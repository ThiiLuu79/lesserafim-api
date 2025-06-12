package com.lesserafim.lesserafimBE.service;

import com.lesserafim.lesserafimBE.api.model.Member;
import com.lesserafim.lesserafimBE.repository.MemberRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class MemberServiceTest {

    private MemberRepository memberRepository;
    private MemberService memberService;

    @BeforeEach
    public void setUp() {
        memberRepository = mock(MemberRepository.class);

        // Sample member data
        Member sample = new Member();
        sample.setId(1);
        sample.setName("Kim Chaewon");
        sample.setBirthday(new Date());
        sample.setPosition("Leader, Vocalist");

        when(memberRepository.findAll()).thenReturn(List.of(sample));

        memberService = new MemberService(memberRepository);
    }

    @Test
    public void testGetAllMembers() {
        List<Member> members = memberService.getAllMembers();
        assertNotNull(members);
        assertFalse(members.isEmpty());
        assertEquals("Kim Chaewon", members.get(0).getName());
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

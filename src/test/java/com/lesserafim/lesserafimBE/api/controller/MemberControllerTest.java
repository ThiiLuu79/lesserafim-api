package com.lesserafim.lesserafimBE.api.controller;

import com.lesserafim.lesserafimBE.api.model.Member;
import com.lesserafim.lesserafimBE.service.MemberService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

public class MemberControllerTest {

    @Mock
    private MemberService memberService;

    @InjectMocks
    private MemberController memberController;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testGetAllMembers_ReturnsList() {
        Member member1 = new Member();
        Member member2 = new Member();
        List<Member> mockList = Arrays.asList(member1, member2);

        when(memberService.getAllMembers()).thenReturn(mockList);

        ResponseEntity<?> response = memberController.getAllMembers();

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(mockList, response.getBody());
    }

    @Test
    public void testGetAllMembers_ReturnsNotFound() {
        when(memberService.getAllMembers()).thenReturn(Collections.emptyList());

        ResponseEntity<?> response = memberController.getAllMembers();

        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
        assertEquals("No members found.", response.getBody());
    }

    @Test
    public void testGetMemberById_ValidId() {
        int id = 1;
        Member member = new Member();

        when(memberService.getMemberById(id)).thenReturn(member);

        ResponseEntity<?> response = memberController.getMemberById(id);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(member, response.getBody());
    }

    @Test
    public void testGetMemberById_NotFound() {
        int id = 99;

        when(memberService.getMemberById(id)).thenReturn(null);

        ResponseEntity<?> response = memberController.getMemberById(id);

        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
        assertEquals("No member found for the given ID.", response.getBody());
    }

    @Test
    public void testGetMemberById_NullId() {
        ResponseEntity<?> response = memberController.getMemberById(null);

        assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
        assertEquals("ID parameter cannot be null.", response.getBody());
    }

    @Test
    public void testGetMemberById_InternalServerError() {
        int id = 1;
        when(memberService.getMemberById(id)).thenThrow(new RuntimeException("Database error"));

        ResponseEntity<?> response = memberController.getMemberById(id);

        assertEquals(HttpStatus.INTERNAL_SERVER_ERROR, response.getStatusCode());
        assertEquals("An error occurred while processing the request.", response.getBody());
    }
}

package com.lesserafim.lesserafimBE.service;

import com.lesserafim.lesserafimBE.api.model.Member;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

@Service
public class MemberService {

    private List<Member> members = new ArrayList<>();

    public MemberService() {
        loadMembersFromJson();
    }

    private void loadMembersFromJson() {
        ObjectMapper objectMapper = new ObjectMapper();
        try (InputStream inputStream = getClass().getClassLoader().getResourceAsStream("membersdata.json")) {
            if (inputStream != null) {
                members = objectMapper.readValue(inputStream, new TypeReference<List<Member>>() {});
            } else {
                throw new RuntimeException("members.json not found in resources.");
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Failed to load members from JSON file.");
        }
    }

    public List<Member> getAllMembers() {
        return members;
    }

    public Member getMemberById(int id) {
        return members.stream()
                .filter(member -> member.getId() == id)
                .findFirst()
                .orElse(null);
    }
}

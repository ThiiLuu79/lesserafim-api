package com.lesserafim.lesserafimBE.service;

import com.lesserafim.lesserafimBE.api.model.Member;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.lesserafim.lesserafimBE.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

@Service
public class MemberService {

    private List<Member> members = new ArrayList<>();
    private final MemberRepository memberRepository;

    @Autowired
    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
        loadMemberFromDatabase();
    }

    private void loadMemberFromDatabase() {
        try {
            List<Member> dbMembers = memberRepository.findAll();
            if (!dbMembers.isEmpty()) {
                members = dbMembers;
                System.out.println("Fetching members from MongoDB.");
                return;
            }
            System.out.println("No members found in the database.");
        } catch (Exception e) {
            System.out.println("Failed to load members from database: " + e.getMessage());
        }
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

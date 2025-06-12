package com.lesserafim.lesserafimBE.service;

import com.lesserafim.lesserafimBE.api.model.Member;
import com.lesserafim.lesserafimBE.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MemberService {

    private final MemberRepository memberRepository;

    @Autowired
    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    public List<Member> getAllMembers() {
        // Always fetch fresh data from MongoDB
        return memberRepository.findAll();
    }

    public Member getMemberById(int id) {
        // Also fetches fresh data every time
        return memberRepository.findAll().stream()
                .filter(member -> member.getId() == id)
                .findFirst()
                .orElse(null);
    }
}

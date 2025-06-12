package com.lesserafim.lesserafimBE.repository;

import com.lesserafim.lesserafimBE.api.model.Member;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface MemberRepository extends MongoRepository<Member, Integer> {
}

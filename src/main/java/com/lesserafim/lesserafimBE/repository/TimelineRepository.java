package com.lesserafim.lesserafimBE.repository;

import com.lesserafim.lesserafimBE.api.model.Timeline;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface TimelineRepository extends MongoRepository<Timeline, Integer> {
}

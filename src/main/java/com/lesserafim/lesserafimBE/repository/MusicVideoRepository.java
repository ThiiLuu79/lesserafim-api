package com.lesserafim.lesserafimBE.repository;

import com.lesserafim.lesserafimBE.api.model.MusicVideo;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface MusicVideoRepository extends MongoRepository<MusicVideo, Integer> {
}

package com.lesserafim.lesserafimBE.repository;

import com.lesserafim.lesserafimBE.api.model.Discography;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface DiscographyRepository extends MongoRepository<Discography, Integer> {
}

package com.mellisphera.repositories;

import com.mellisphera.entities.HubReferences;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface HubReferencesRepository extends MongoRepository<HubReferences, String> {

    public List<HubReferences> findByUserId(String userId);
}

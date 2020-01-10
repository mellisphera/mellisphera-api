package com.mellisphera.repositories;

import com.mellisphera.entities.HubReferences;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface HubReferencesRepository extends MongoRepository<HubReferences, String> {
}

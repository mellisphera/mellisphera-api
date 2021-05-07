package com.mellisphera.repositories;

import com.mellisphera.entities.Fitness;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.domain.Sort;

import java.util.Date;
import java.util.List;

public interface FitnessRepository extends MongoRepository<Fitness, String> {

    List<Fitness> findByUserIdAndDateBetween(String userId, Date start, Date end);
    List<Fitness> findByUserId(String userId);
    List<Fitness> findByHiveIdAndDateBetween(String userId, Date start, Date end, Sort sort);
}

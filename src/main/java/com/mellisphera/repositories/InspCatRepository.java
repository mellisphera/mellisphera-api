package com.mellisphera.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;

import com.mellisphera.entities.InspCat;


@Service
@Repository
public interface InspCatRepository extends MongoRepository<InspCat ,String>{

    List<InspCat> findInspCatByType(String type);

}

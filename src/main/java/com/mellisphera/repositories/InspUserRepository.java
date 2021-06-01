package com.mellisphera.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.mellisphera.entities.InspUser;


@Service
@Repository
public interface InspUserRepository extends MongoRepository<InspUser ,String>{
    
    InspUser findInspUserBy_id(String _id);

    InspUser findInspUserByIdUser(String idUser);

    boolean existsByIdUser(String idUser);

}

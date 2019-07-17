package com.mellisphera.repositories;

import java.util.Date;
import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.mellisphera.entities.Astro;

@Service
@Repository
public interface AstroRepository extends MongoRepository<Astro, String> {

	public List<Astro> findBy_idApiaryAndDateBetween(String _idApiary, Date start, Date end);

}

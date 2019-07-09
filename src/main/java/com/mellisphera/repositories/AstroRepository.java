package com.mellisphera.repositories;

import java.util.Date;
import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.mellisphera.entities.Astro;

public interface AstroRepository extends MongoRepository<Astro, String> {

	public List<Astro> findByIdApiaryAndDateBetween(String idApiary, Date start, Date end);

}

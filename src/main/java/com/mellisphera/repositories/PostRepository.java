package com.mellisphera.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.mellisphera.entities.Post;


@Service
@Repository
public interface PostRepository extends MongoRepository<Post,String>{

	
	Post findPostById(String id);
	
}

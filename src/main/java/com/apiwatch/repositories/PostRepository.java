package com.apiwatch.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.apiwatch.entities.Post;


@Service
@Repository
public interface PostRepository extends MongoRepository<Post,String>{

}

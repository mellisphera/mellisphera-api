package com.example.demo.repositories;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import com.example.demo.entities.User;

@Service
@Repository
public interface UserRepository extends MongoRepository<User,String>{
	
	@Query(value = "{User.username:?0}")
	List<User> findByUsername(String username);
	
	User findUserByUsername(String username);
	List<User> findByCreatedAtLike(String todayDate);
}



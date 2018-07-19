package com.apiwatch;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableScheduling;

import com.apiwatch.repositories.PostRepository;



@EnableScheduling
@SpringBootApplication
public class LemabkrApplication{

	@Autowired private PostRepository PostsRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(LemabkrApplication.class, args);
	}
	
	
}

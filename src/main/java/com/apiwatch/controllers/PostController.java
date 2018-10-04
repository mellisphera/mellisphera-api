package com.apiwatch.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.apiwatch.entities.Post;
import com.apiwatch.entities.Record;
import com.apiwatch.repositories.PostRepository;

@Service
@RestController
@RequestMapping("posts")
public class PostController {
	
	@Autowired
    private PostRepository postRepository;

    public PostController() {
    }

    public PostController(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    @RequestMapping(value = "/all", method = RequestMethod.GET, produces={"application/json"})
    public List<Post> getAll(){
    List<Post> posts=this.postRepository.findAll();
    return posts;
    }

    @PostMapping
    public void insert(@RequestBody Post post){
        this.postRepository.insert(post);
    }

    @RequestMapping(value = "/update/{id}", method = RequestMethod.PUT) 
    public void update(@PathVariable("id") String id, @RequestBody Post post){ 
    	Post p = this.postRepository.findPostById(id);
    	p.setContent(post.getContent());
 		p.setTitle(post.getTitle());
 		p.setLoveIts(post.getLoveIts());
 		this.postRepository.save(p);
    	
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") String id){
      this.postRepository.deleteById(id);
    }

 
    @GetMapping("getOne/{id}")
    public Post getById(@PathVariable("id") String id){    	
    	Post p = this.postRepository.findPostById(id);
    	if (p != null) {
    		return p;
    	} else {
    		return null;
    	}
        
    }
	
}

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
@CrossOrigin(origins = {"http://localhost:4200", "http://***REMOVED***:4200","http://***REMOVED***:4300"})
public class PostController {
	
	@Autowired
    private PostRepository PostRepository;

    public PostController() {
    }

    public PostController(PostRepository PostRepository) {
        this.PostRepository = PostRepository;
    }

    @RequestMapping(value = "/all", method = RequestMethod.GET, produces={"application/json"})
    public List<Post> getAll(){
    List<Post> posts=this.PostRepository.findAll();
    return posts;
    }

    @PostMapping
    public void insert(@RequestBody Post post){
        this.PostRepository.insert(post);
    }

    @RequestMapping(value = "/update/{id}", method = RequestMethod.PUT) 
    public void update(@PathVariable("id") String id, @RequestBody Post post){ 
    	 List<Post> posts= this.PostRepository.findAll();
         for(Post p : posts){
         	if(p.getId().equals(id)) {
         		p.setContent(post.getContent());
         		p.setTitle(post.getTitle());
         		p.setLoveIts(post.getLoveIts());
         		this.PostRepository.save(p);
         	}
         }
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") String id){
      this.PostRepository.deleteById(id);
    }

 
    @GetMapping("getOne/{id}")
    public Post getById(@PathVariable("id") String id){
        List<Post> posts= this.PostRepository.findAll();
        for(Post p : posts){
        	if(p.getId().equals(id)) {
        		return p;
        	}
        }
        return null;
    }
	
}

package com.apiwatch.controllers;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.TimeZone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.apiwatch.entities.User;
import com.apiwatch.repositories.UserRepository;

@RestController
@RequestMapping("/user")
@CrossOrigin(origins = {"http://localhost:4200", "http://51.68.71.91:4200","http://51.68.71.91:4300"})
public class UserController {
	@Autowired
    private UserRepository UserRepository;
	
    public UserController() {
	    }

    public UserController(UserRepository UserRepository) {
	        this.UserRepository = UserRepository;
	        //this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    @PostMapping("/signup")
    public void signUp(@RequestBody User u){
    	Date date = new Date();
        // display time and date using toString()
    	u.setCreatedAt(date);
    	this.UserRepository.insert(u);
    }
    
    @GetMapping("/all")
    public List<User> getAll(){
    List<User> Users=this.UserRepository.findAll();
    return Users;
    }
    
    @GetMapping("/usernames")
    public List<String> getAllRuchers(){
    List<User> Users=this.UserRepository.findAll();
    List<String> names = new ArrayList<>();
    for(User e : Users) {
    	names.add(e.getUsername());
    }
    return names;
    }
   
    @GetMapping("/createdAt")
    public List<User> findByCreatedDate(){
    
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd"); // Quoted "Z" to indicate UTC, no timezone offset
	    List<User> Users=this.UserRepository.findAll();
	    List<User> todayUsers = new ArrayList<>();
	    //System.out.println("Today date : "+ nowAsISO );
	    
	    System.out.println("new Date().getDate(): " + df.format(new Date()));
    	for(User e : Users) {
    		//System.out.println("e.getCreatedAt.getDate(): " + df.format(e.getCreatedAt()));
    		//System.out.println("USERNAME : " + e.getUsername());
    		if(df.format(e.getCreatedAt()).equals(df.format(new Date()))) {
    			todayUsers.add(e);
    		}
    		
    	 }
    	    
   	 
    	return todayUsers;
    }
    
    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") String id){
      this.UserRepository.deleteById(id);
    }
    
    @GetMapping("/{id}")
    public Optional<User> getById(@PathVariable("id") String id){
        Optional<User> User = this.UserRepository.findById(id);
        return User;
    }
    
    @RequestMapping(value="/loguser", method=RequestMethod.POST,consumes="application/json", produces = "application/json")
    public Boolean checkLogin(@RequestBody User u ){    
    	User u1 = this.UserRepository.findUserByUsername(u.getUsername());
        System.out.println("user :" + u);
        if(u.getPassword().equals(u1.getPassword()))
        	return true;
        else
        	return false;
    }
    
    
    
    
    
    
    
	
}

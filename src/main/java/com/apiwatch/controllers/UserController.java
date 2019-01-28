package com.apiwatch.controllers;

import com.apiwatch.HttpsGetRequest;
import com.apiwatch.entities.Connection;
import com.apiwatch.entities.Location;
import com.apiwatch.entities.Login;
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

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
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
import com.apiwatch.repositories.ConnectionRepository;
import com.apiwatch.repositories.UserRepository;
import com.mongodb.util.JSON;

import java.util.HashMap;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Service;
import org.json.*;

//{ "ADMIN", "STANDARD", "PREMIUM" }
@Service
@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired private UserRepository userRepository;
	@Autowired private ConnectionRepository connectionRepository;

	public UserController() {

	}

	public UserController(UserRepository userRepository, ConnectionRepository connectionRepository) {
		this.userRepository = userRepository;
		//this.bCryptPasswordEncoder = bCryptPasswordEncoder;
	}

	/**
	@PostMapping("/signup")
	public void signUp(@RequestBody User u){
		Date date = new Date();
		// display time and date using toString()
		u.setCreatedAt(date);
		this.userRepository.insert(u);
	}
	**/
	@PreAuthorize("hasRole('ADMIN') or hasRole('PREMIUM')")
	@GetMapping("/all")
	public List<User> getAll(){
		List<User> Users=this.userRepository.findAll();
		return Users;
	}

	public void setDataConnection(User user, HttpServletRequest request){
		HttpsGetRequest http = new HttpsGetRequest();
		Location location = null;
		http.setIp(request.getRemoteAddr());
		System.err.println(request.getRemoteAddr());
		JSONParser parser = new JSONParser(); 
		try {
			JSONObject json = (JSONObject) parser.parse(http.getLocation());
			location = new Location(json);
			System.out.println(location.toString());
			System.out.println(json.get("country"));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		long nbConnectionTotal = user.getConnexions();
		Connection newConnection = new Connection(new Date(),request.getRemoteAddr(),user.getId(),user.getLogin(),location);
		user.setConnexions(nbConnectionTotal+1);
		user.setLastConnection(new Date());
		this.userRepository.save(user);
		this.connectionRepository.save(newConnection);
	}

	@GetMapping("/usernames")
	public List<String> getAllRuchers(){
		List<User> Users=this.userRepository.findAll();
		List<String> names = new ArrayList<>();
		for(User e : Users) {
			names.add(e.getLogin().getUsername());
		}
		return names;
	}

	@GetMapping("/createdAt")
	public List<User> findByCreatedDate(){

		DateFormat df = new SimpleDateFormat("yyyy-MM-dd"); // Quoted "Z" to indicate UTC, no timezone offset
		List<User> Users=this.userRepository.findAll();
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
		this.userRepository.deleteById(id);
	}

	@GetMapping("/{id}")
	public Optional<User> getById(@PathVariable("id") String id){
		Optional<User> User = this.userRepository.findById(id);
		return User;
	}
	@RequestMapping(value="/loguser", method=RequestMethod.POST,consumes="application/json", produces = "application/json")
    public User checkLogin(@RequestBody Login login,HttpServletRequest request, HttpServletResponse res ){
        User user = null;
        user = this.userRepository.findUserByLogin(login);  
        if(user != null){
			System.out.println(request.getRemoteAddr());
			if(request.getRemoteAddr() != "0:0:0:0:0:0:0:1"){
				this.setDataConnection(user,request);
			}
			//resultatLogin.put(u.getLastConnection(), true);
            return user;
        }
        else{
            return new User(true);
        }
    }

	/*@RequestMapping(value="/loguser", method=RequestMethod.POST,consumes="application/json", produces = "application/json")
	public User checkLogin(@RequestBody Login login, HttpServletRequest request, HttpServletResponse res){
		System.out.println(login.toString());
		List<User> user = this.userRepository.findAll();
		for(User u : user){
			if(u.getLogin().getUsername().equals(login.getUsername()) && u.getLogin().getPassword().equals(login.getPassword())){
				System.out.println(request.getRemoteAddr());
				if(request.getRemoteAddr() != "0:0:0:0:0:0:0:1"){
					this.setDataConnection(u,request);
				}
				//resultatLogin.put(u.getLastConnection(), true);
				return u;
			}
		}
		//resultatLogin.put(new Date(), false);
		return new User(true);
	}*/

}

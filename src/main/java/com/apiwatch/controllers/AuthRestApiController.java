/**
 * 
 */
package com.apiwatch.controllers;

import java.util.Date;
import java.util.GregorianCalendar;

import javax.validation.Valid;

//import com.apiwatch.entities.Login;
import com.apiwatch.entities.User;
import com.apiwatch.repositories.UserRepository;
import com.apiwatch.security.entities.ApiWatchUserDetails;
import com.apiwatch.security.jwt.JwtProvider;
import com.apiwatch.security.message.request.LoginForm;
import com.apiwatch.security.message.response.JwtResponse;
import com.apiwatch.security.message.response.ResponseMessage;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import org.springframework.security.core.Authentication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author epa
 *
 */
@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/auth")
public class AuthRestApiController {
	Log log = LogFactory.getLog(AuthRestApiController.class);

	@Autowired
	AuthenticationManager authenticationManager;

	@Autowired
	UserRepository userRepository;

	@Autowired
	PasswordEncoder encoder;

	@Autowired
	JwtProvider jwtProvider;

	/**
	 * 
	 * @param loginRequest
	 * @return
	 */
	@PostMapping("/signin")
	public ResponseEntity<?> authenticateUser(@Valid @RequestBody LoginForm loginRequest) {
		log.debug(" Sign Up : username :" + loginRequest.getUsername() + " password:" + loginRequest.getPassword());

		Authentication authentication = authenticationManager.authenticate(
				new UsernamePasswordAuthenticationToken(loginRequest.getUsername(),loginRequest.getPassword()));
		log.debug(" Sign Up : AUTH OK");
		SecurityContextHolder.getContext().setAuthentication(authentication);

		String jwt = jwtProvider.generateJwtToken(authentication);
		ApiWatchUserDetails apiWatchUserDetails = (ApiWatchUserDetails) authentication.getPrincipal();

		return ResponseEntity.ok(new JwtResponse(jwt, apiWatchUserDetails.getUsername(), apiWatchUserDetails.getAuthorities()));
	}

	/**
	 * 	
	 * @param signUpRequest
	 * @return
	 */
	@PostMapping("/signup")
	public ResponseEntity<?> registerUser(@Valid @RequestBody User signUpRequest) {
		log.debug(" Sign Up : username :"+ signUpRequest.getUsername() +" password :"+signUpRequest.getPassword()+" email:" + signUpRequest.getEmail());
		//
		//Login credential = new Login(signUpRequest.getUsername(),encoder.encode(signUpRequest.getPassword()));
		String credential = encoder.encode(signUpRequest.getPassword());
		//
		log.debug(" Sign Up : username :"+ signUpRequest.getUsername() +" password :" + credential);
		//Search if user already exit
		if (userRepository.findUserByUsername( signUpRequest.getUsername()) != null) {
			log.error(" Sign Up : Fail -> Username is already taken! "+ signUpRequest.getUsername() );
			return new ResponseEntity<>(new ResponseMessage("Fail -> Username is already taken!"),
					HttpStatus.BAD_REQUEST);
		}
		/**
		if (userRepository.existsByUsername(signUpRequest.getUsername())) {
			return new ResponseEntity<>(new ResponseMessage("Fail -> Username is already taken!"),
					HttpStatus.BAD_REQUEST);
		}

		if (userRepository.existsByEmail(signUpRequest.getEmail())) {
			return new ResponseEntity<>(new ResponseMessage("Fail -> Email is already in use!"),
					HttpStatus.BAD_REQUEST);
		}
	**/
		//public User(String id, Date createdAt, Login login, String phone, String email, long connexions,Date lastConnection, String fullName, String position, String city, int levelUser, String country)
		//                    String id, Date createdAt, String username, String password, String phone, String email, long connexions,Date lastConnection, String fullName, String position, String city, int levelUser, String country
		// Creating user's account
		User user = new User(signUpRequest.getId(), GregorianCalendar.getInstance().getTime(),signUpRequest.getUsername(), credential,signUpRequest.getPhone(),signUpRequest.getEmail(),0L,null,signUpRequest.getFullName(),signUpRequest.getPosition(),signUpRequest.getCity(), signUpRequest.getCountry(),signUpRequest.getRoles());
		/**
		user.setUsername(credential.getUsername());
		user.setPassword(credential.getPassword());
		**/
		userRepository.insert(user);
		
		return new ResponseEntity<>(new ResponseMessage("User registered successfully!"), HttpStatus.OK);
	}
}

/**
 * 
 */
package com.mellisphera.controllers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashSet;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.WebAuthenticationDetails;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mellisphera.entities.Connection;
import com.mellisphera.entities.User;
import com.mellisphera.repositories.ConnectionRepository;
import com.mellisphera.repositories.UserRepository;
import com.mellisphera.security.entities.ApiWatchUserDetails;
import com.mellisphera.security.entities.BmAuth;
import com.mellisphera.security.entities.GeoIp;
import com.mellisphera.security.jwt.JwtProvider;
import com.mellisphera.security.message.request.LoginForm;
import com.mellisphera.security.message.request.SignUpForm;
import com.mellisphera.security.message.response.JwtResponse;
import com.mellisphera.security.message.response.ResponseMessage;
import com.mellisphera.security.service.BmAuthServiceImpl;
import com.mellisphera.security.service.GeoipServiceImpl;

/**
 * @author epa
 *
 */
@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/auth")
public class AuthRestApiController {
	public static Log log = LogFactory.getLog(AuthRestApiController.class);
	//
	public static final String[] SET_INITIAL_ROLE = new String[] { "ROLE_STANDARD" };

	@Autowired
	AuthenticationManager authenticationManager;

	@Autowired
	UserRepository userRepository;

	@Autowired
	ConnectionRepository connectionRepository;

	@Autowired
	PasswordEncoder encoder;

	@Autowired
	JwtProvider jwtProvider;

	@Autowired
	GeoipServiceImpl geoipService;

	@Autowired
	BmAuthServiceImpl bmAuthService;

	/**
	 * 
	 * @param loginRequest
	 * @return
	 */
	@PostMapping("/signin")
	public ResponseEntity<?> authenticateUser(@Valid @RequestBody LoginForm loginRequest, HttpServletRequest request) {
		log.debug(" Sign Up : username :" + loginRequest.getEmail() + " password:" + loginRequest.getPassword());
		//
		System.err.println(loginRequest);
		ApiWatchUserDetails apiWatchUserDetails = null;
		String jwt = null;
		User user = null;
		try {
			Authentication authentication = authenticationManager.authenticate(
					new UsernamePasswordAuthenticationToken(loginRequest.getEmail(),loginRequest.getPassword()));
			SecurityContextHolder.getContext().setAuthentication(authentication);
			//
			jwt = jwtProvider.generateJwtToken(authentication);
			apiWatchUserDetails = (ApiWatchUserDetails) authentication.getPrincipal();
			user = this.userRepository.findUserByEmail(loginRequest.getEmail());
		}
		catch(AuthenticationException e) {
			System.err.println("");
			BmAuth bmAuth = bmAuthService.getBmAuth(loginRequest.getEmail(), loginRequest.getPassword());
			if (bmAuth.getCode().equals("201")) {
				throw new UsernameNotFoundException("Login incorrecte");
			} else {
				// loginRequest.setEmail(bmAuth.getMessage().substring(26, bmAuth.getMessage().length() - 1));
				this.registerUser(new SignUpForm(loginRequest.getEmail().split("@")[0], loginRequest.getEmail(), new HashSet<>(Arrays.asList(SET_INITIAL_ROLE)), loginRequest.getPassword()), request);
				user = this.userRepository.findUserByEmail(loginRequest.getEmail());
				this.bmAuthService.saveBmData(bmAuth, user);
				Authentication authentication = authenticationManager.authenticate(
						new UsernamePasswordAuthenticationToken(loginRequest.getEmail(),loginRequest.getPassword()));
				SecurityContextHolder.getContext().setAuthentication(authentication);
				//
				jwt = jwtProvider.generateJwtToken(authentication);
				apiWatchUserDetails = (ApiWatchUserDetails) authentication.getPrincipal();
				user = this.userRepository.findUserByEmail(loginRequest.getEmail());
			}

		}
		System.err.println(user);
		String ipAddress = request.getRemoteAddr();
		GeoIp geoIp = geoipService.getGeoIp(ipAddress);
		Calendar calendar = new GregorianCalendar();
		user.incrementConnexions();
		Date date = new Date();
		date.setHours(new Date().getHours()+1);
		user.setLastConnection(date);
		this.userRepository.save(user);
		if(ipAddress != "127.0.0.1" || ipAddress != "0:0:0:0:0:0:0:1") {
			Connection connection = new Connection(date, user.getId(), user.getUsername(), geoIp);
			System.err.println(connection);
			System.err.println(this.connectionRepository.insert(connection));
		} else {
			geoIp = geoipService.getGeoIp("83.173.67.13");
		}
		return ResponseEntity.ok(new JwtResponse(jwt, user.getConnexions(), apiWatchUserDetails.getUsername(),user.getEmail(), apiWatchUserDetails.getAuthorities(),geoIp.getCountry()));
	}

	/**
	 * 	
	 * @param signUpRequest
	 * @return
	 */
	@PostMapping("/signup")
	public ResponseEntity<?> registerUser(@Valid @RequestBody SignUpForm signUpRequest, HttpServletRequest request) {
		log.debug(" Sign Up : username :"+ signUpRequest.getUsername() +" password :"+signUpRequest.getPassword()+" email:" + signUpRequest.getEmail());
		//
		//Login credential = new Login(signUpRequest.getUsername(),encoder.encode(signUpRequest.getPassword()));
		String credential = encoder.encode(signUpRequest.getPassword());
		//
		log.debug(" Sign Up : username :"+ signUpRequest.getUsername() +" password :" + credential);
		//Search if user already exit
		System.err.println(signUpRequest.getEmail());
		if (userRepository.existsByEmail(signUpRequest.getUsername())) {
			return new ResponseEntity<>(new ResponseMessage("Fail -> Username is already taken!"),
					HttpStatus.BAD_REQUEST);
		}

		if (userRepository.existsByEmail(signUpRequest.getEmail())) {
			return new ResponseEntity<>(new ResponseMessage("Fail -> Email is already in use!"),
					HttpStatus.BAD_REQUEST);
		}
		/** **/
		//public User(String id, Date createdAt, Login login, String phone, String email, long connexions,Date lastConnection, String fullName, String position, String city, int levelUser, String country)
		//                    String id, Date createdAt, String username, String password, String phone, String email, long connexions,Date lastConnection, String fullName, String position, String city, int levelUser, String country
		// Creating user's account
		User user = new User(GregorianCalendar.getInstance().getTime(),signUpRequest.getUsername(), credential,signUpRequest.getEmail(),new HashSet<>(Arrays.asList(SET_INITIAL_ROLE)));
		//search country by ip
		String ipAddress = ((WebAuthenticationDetails)SecurityContextHolder.getContext().getAuthentication().getDetails()).getRemoteAddress();
		//String ipAddress = request.getRemoteAddr();
		if (ipAddress.equals("127.0.0.1"))
			ipAddress="87.100.21.93";
		log.debug(" remote ip :"+ ipAddress);
		//
		GeoIp geoIp = geoipService.getGeoIp(ipAddress);
		//
		user.setCity(geoIp.getCity());
		// save user
		userRepository.insert(user);
		//
		return new ResponseEntity<>(new ResponseMessage("User registered successfully!"), HttpStatus.OK);
	}
}

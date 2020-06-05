/* Copyright 2018-present Mellisphera
Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at
http://www.apache.org/licenses/LICENSE-2.0
Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License. */ 



/**
 * 
 */
package com.mellisphera.security.jwt;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.web.filter.OncePerRequestFilter;

import com.mellisphera.security.entities.ApiWatchUserDetails;
import com.mellisphera.security.service.UserDetailsServiceImpl;

/**
 * @author epa
 *
 */
public class JwtAuthTokenFilter extends OncePerRequestFilter {
	private static final Log log = LogFactory.getLog(JwtAuthTokenFilter.class);
	private static final String PUBLIC_TOKEN = "eyJhbGciOiJIUzUxMiJ9.eyJleHAiOjE1NTA5Mjc3NzgsInN1YiI6IkZTVEwiLCJpYXQiOjE1NTA4NDEzNzh9.H1KLyl0AlmaIY-6dVQL_6R9FVL9X42-8hPtuqn0UwBR5FnfkPioVajF1qyVdYgl5W836YuESGhhuP60D8ii7HQ";
	@Autowired
	private JwtProvider tokenProvider;

	@Autowired
	private UserDetailsServiceImpl userDetailsService;
	
	/* (non-Javadoc)
	 * @see org.springframework.web.filter.OncePerRequestFilter#doFilterInternal(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse, javax.servlet.FilterChain)
	 */
	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		try {

			String jwt = getJwt(request);
			if (jwt != null && tokenProvider.validateJwtToken(jwt)) {
				String email = tokenProvider.getUserNameFromJwtToken(jwt);
				log.debug("Jwt username :"+email);
				//
				ApiWatchUserDetails apiWatchUserDetails = userDetailsService.loadUserByUsername(email);
				log.debug("Load userDetails id :"+apiWatchUserDetails.getEmail());
				//
				UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(
						apiWatchUserDetails.getUsername(), apiWatchUserDetails.getPassword(), apiWatchUserDetails.getAuthorities());
				//
				log.debug("authentication pass :"+authentication.toString());
				//
				authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
				//
				log.debug("authentication.setDetails pass");
				//
				SecurityContextHolder.getContext().setAuthentication(authentication);
				//
				log.debug("setAuthentication pass");
			}
		} catch (Exception e) {
			log.error("Can NOT set user authentication -> Message: {}", e);
		}

		filterChain.doFilter(request, response);

	}
	
	/**
	 * 
	 * @param request
	 * @return
	 */
	private String getJwt(HttpServletRequest request) {
		String authHeader = request.getHeader("Authorization");
		//
		log.debug("authHeader :"+authHeader);
		if (authHeader != null && authHeader.startsWith("Bearer ")) {
			String output = authHeader.replace("Bearer ", "");
			if (output.equals("null")) {
				return null;
			}
			return output;
		}

		return null;
	}
}

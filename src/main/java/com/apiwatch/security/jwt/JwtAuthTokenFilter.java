/**
 * 
 */
package com.apiwatch.security.jwt;

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

import com.apiwatch.security.entities.ApiWatchUserDetails;
import com.apiwatch.security.service.UserDetailsServiceImpl;

/**
 * @author epa
 *
 */
public class JwtAuthTokenFilter extends OncePerRequestFilter {
	private static final Log log = LogFactory.getLog(JwtAuthTokenFilter.class);
	
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
				String username = tokenProvider.getUserNameFromJwtToken(jwt);
				log.debug("Jwt username :"+username);
				//
				ApiWatchUserDetails apiWatchUserDetails = userDetailsService.loadUserByUsername(username);
				log.debug("Load userDetails id :"+apiWatchUserDetails.getUsername());
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
			return authHeader.replace("Bearer ", "");
		}

		return null;
	}
}

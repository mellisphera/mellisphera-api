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

import java.util.Date;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import com.mellisphera.security.entities.ApiWatchUserDetails;

import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.SignatureException;
import io.jsonwebtoken.UnsupportedJwtException;

/**
 * @author epa
 *
 */
@Component
public class JwtProvider {
	private static final Log log = LogFactory.getLog(JwtProvider.class);
	
	@Value("${apiwatch.app.security.jwtSecret}")
    private String jwtSecret;

    @Value("${apiwatch.app.security.jwtExpiration}")
    private int jwtExpiration;
    
    /**
     * 
     * @param authentication
     * @return
     */
    public String generateJwtToken(Authentication authentication) {

        ApiWatchUserDetails userPrincipal = (ApiWatchUserDetails) authentication.getPrincipal();
        log.debug("userPrincipal :"+userPrincipal);
        // build token
        return Jwts.builder()
		                .setSubject((userPrincipal.getEmail()))
		                .setIssuedAt(new Date())
		                .setExpiration(new Date((new Date()).getTime() + jwtExpiration*1000))
		                .signWith(SignatureAlgorithm.HS512, jwtSecret)
		                .compact();
    }
    
    /**
     * 
     * @param authToken
     * @return
     */
    public boolean validateJwtToken(String authToken) {
        try {
        	log.debug("Token :"+authToken);
            Jwts.parser().setSigningKey(jwtSecret).parseClaimsJws(authToken);
            log.debug("Token PARSING :"+Jwts.parser().setSigningKey(jwtSecret).parseClaimsJws(authToken).getBody());
            return true;
        } catch (SignatureException e) {
            log.error("Invalid JWT signature -> Message: {} ", e);
        } catch (MalformedJwtException e) {
            log.error("Invalid JWT token -> Message: {}", e);
        } catch (ExpiredJwtException e) {
            log.error("Expired JWT token -> Message: {}", e);
        } catch (UnsupportedJwtException e) {
            log.error("Unsupported JWT token -> Message: {}", e);
        } catch (IllegalArgumentException e) {
            log.error("JWT claims string is empty -> Message: {}", e);
        }
        
        return false;
    }
    
    /**
     * 
     * @param token
     * @return
     */
    public String getUserNameFromJwtToken(String token) {
        return Jwts.parser()
			                .setSigningKey(jwtSecret)
			                .parseClaimsJws(token)
			                .getBody().getSubject();
    }
    
    
}
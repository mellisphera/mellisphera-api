/**
 * 
 */
package com.apiwatch.security.jwt;

import java.util.Date;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import com.apiwatch.security.entities.ApiWatchUserDetails;

import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.JwtBuilder;
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
    
    // User token null expiration
    private final static String[] USER_EXCEPTION = {"fstl"};
    /**
     * 
     * @param authentication
     * @return
     */
    public String generateJwtToken(Authentication authentication) {

        ApiWatchUserDetails userPrincipal = (ApiWatchUserDetails) authentication.getPrincipal();
        log.debug("userPrincipal :"+userPrincipal.getUsername());
        // build token
        JwtBuilder jwts = Jwts.builder();
        if(checkUserException(userPrincipal.getUsername())) {
        	jwts.setExpiration(null);
        }
        else {
        	jwts.setExpiration(new Date((new Date()).getTime() + jwtExpiration*1000));
        }
        jwts.setSubject((userPrincipal.getUsername()))
	        .setIssuedAt(new Date())
	        .signWith(SignatureAlgorithm.HS512, jwtSecret)
	        .compact();
        return jwts.compact();

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
    
    public Boolean checkUserException(String username) {
    	int i;
    	for(i=0;i<USER_EXCEPTION.length;i++) {
    		if(USER_EXCEPTION[i].equals(username)){
    			return true;
    		}
    	}
    	return false;
    }
    
    
}

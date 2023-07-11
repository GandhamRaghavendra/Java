package com.grm.jwt.config;

import java.io.IOException;
import java.util.Date;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import javax.crypto.SecretKey;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.grm.jwt.service.UserService;
import com.grm.jwt.service.UserServiceImpl;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class JwtTokenGeneratorFilter extends OncePerRequestFilter {
		
	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {

		System.out.println("inside doFilter....");

		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		if (null != authentication) {

			System.out.println("authenticationnnn " + authentication);

			SecretKey key = Keys.hmacShaKeyFor(SecurityConstants.JWT_KEY.getBytes());

			String jwt = Jwts.builder()
					                  .setIssuer("Raghu")
					                  .setSubject("JWT Token")
					                  .claim("username", authentication.getName())
					                  .claim("role", getRole(authentication.getAuthorities()))
					                  .setIssuedAt(new Date())
					                  .setExpiration(new Date(new Date().getTime() + SecurityConstants.JWT_VALID_TILL)) // expiration time of 30 minute.
					                  .signWith(key)
					                  .compact();
			
			response.setHeader(SecurityConstants.JWT_HEADER, jwt);
		}
		filterChain.doFilter(request, response);
	}
	
	
	/**
	 * 
	 * @param authorities
	 * @return List<String>
	 */
	private List<String> getRole(Collection<? extends GrantedAuthority> authorities) {

		return authorities.stream().map(GrantedAuthority::getAuthority).collect(Collectors.toList());
	}

    //this make sure that this filter will execute only for first time when client call the api /login at first time
	@Override
	protected boolean shouldNotFilter(HttpServletRequest request) throws ServletException {

		return !request.getServletPath().equals("/signIn");
	}

}
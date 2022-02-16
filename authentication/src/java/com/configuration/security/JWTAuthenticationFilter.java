package com.configuration.security;

import com.user.AppUser;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.AllArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;

@AllArgsConstructor
public class JWTAuthenticationFilter extends UsernamePasswordAuthenticationFilter {

	public AuthenticationManager authenticationManager;

	@Override
	public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response)
			throws AuthenticationException {
		AppUser appUser;

		appUser = deserializeRequest(request);

		System.out.println("Attempting Authentication\nusername: " + appUser.getUsername());
		System.out.println("Password: " + appUser.getPassword());

		return authenticationManager.authenticate(
				new UsernamePasswordAuthenticationToken(
						appUser.getUsername(),
						appUser.getPassword()));
	}

	private AppUser deserializeRequest(HttpServletRequest request) {
		try {
			return new ObjectMapper().readValue(request.getInputStream(), AppUser.class);
		} catch (IOException e) {
			throw new RuntimeException(e.getMessage());
		}
	}

	@Override
	protected void successfulAuthentication(
			HttpServletRequest request,
			HttpServletResponse response,
			FilterChain chain,
			Authentication authResult) throws IOException, ServletException {

		User springUser = (User) authResult.getPrincipal();

		String jwt = Jwts.builder()
				.setSubject(springUser.getUsername())
				.setExpiration(new Date(System.currentTimeMillis() +
				                        SecurityConstants.EXPIRATION_TIME))
				.claim("roles", springUser.getAuthorities())
				.signWith(SignatureAlgorithm.HS256, SecurityConstants.SECRET)
				.compact();

		response.addHeader(
				SecurityConstants.HEADER_STRING,
				SecurityConstants.TOKEN_PREFIX + jwt);
	}

}

package tech.ada.web.programacao_web_2.service.impl;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

import javax.crypto.SecretKey;

import org.springframework.stereotype.Service;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import tech.ada.web.programacao_web_2.service.JWTService;

@Service
public class JWTServiceImpl implements JWTService {

	private static SecretKey secretKey = Keys.secretKeyFor(SignatureAlgorithm.HS256);
	private static SecretKey secretKeyRefresh = Keys.secretKeyFor(SignatureAlgorithm.HS256);

	@Override
	public String generateToken(String username) {
		return generateToken(username, secretKey, 30L);
	}

	@Override
	public String generateTokenRefresh(String username) {
		return generateToken(username, secretKeyRefresh, 60L);
	}

	
	private String generateToken(String username, SecretKey key, Long minuteExpiration) {
	
		LocalDateTime now = LocalDateTime.now();
		LocalDateTime expire = now.plusMinutes(minuteExpiration);
		
		return Jwts.builder()
				.setIssuedAt(new Date(now.atZone(ZoneId.systemDefault()).toInstant().toEpochMilli()))
				.setExpiration(new Date(expire.atZone(ZoneId.systemDefault()).toInstant().toEpochMilli()))
				.setSubject(username)
				.signWith(key)
				.compact();		
		
	}

	@Override
	public boolean validToken(String token) {
		
		return validToken(token, secretKey);
		
	}
	
	@Override
	public boolean validRefreshToken(String token) {
		
		return validToken(token, secretKeyRefresh);
		
	}

	private boolean validToken(String token, SecretKey key) {
		return Jwts.parserBuilder()
				.setSigningKey(key)
				.build()
				.isSigned(token);
	}

	@Override
	public String getUserByToken(String token) {
		return getUserByToken(token, secretKey);
	}
	
	@Override
	public String getUserByRefreshToken(String token) {
		
		return getUserByToken(token, secretKeyRefresh);
		
	}

	private String getUserByToken(String token, SecretKey key) {
		return Jwts.parserBuilder()
				.setSigningKey(key)
				.build()
				.parseClaimsJws(token)
				.getBody()
				.getSubject();
	}

}

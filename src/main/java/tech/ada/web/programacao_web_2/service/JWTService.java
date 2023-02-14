package tech.ada.web.programacao_web_2.service;

public interface JWTService {

	String generateToken(String username);

	String generateTokenRefresh(String username);

	boolean validToken(String token);

	boolean validRefreshToken(String token);

	String getUserByToken(String token);

	String getUserByRefreshToken(String token);
	
}

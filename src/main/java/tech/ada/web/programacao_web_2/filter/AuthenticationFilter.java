package tech.ada.web.programacao_web_2.filter;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import tech.ada.web.programacao_web_2.model.entity.Usuario;
import tech.ada.web.programacao_web_2.service.JWTService;
import tech.ada.web.programacao_web_2.service.impl.AuthServiceImpl;

@Component
public class AuthenticationFilter extends OncePerRequestFilter {

	@Autowired
	private JWTService jwtService;
	
	@Autowired
	private AuthServiceImpl authService;
	
	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {

		String token = request.getHeader("Authorization");
		
		if (token != null && !token.isBlank()) {
			
			token = token.replace("Bearer ", "");
			
			if (jwtService.validToken(token)) {
				
				String user = jwtService.getUserByToken(token);
				
				if (!user.isBlank() && SecurityContextHolder.getContext().getAuthentication() == null) {
					
					Usuario usuario = (Usuario) authService.loadUserByUsername(user);
					
					UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(
							usuario.getUsuario(),
							null,
							usuario.getAuthorities());
					
					SecurityContextHolder.getContext().setAuthentication(authentication);
					
				}
				
			}
			
		}
		
		filterChain.doFilter(request, response);
		
	}

}

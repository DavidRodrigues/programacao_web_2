package tech.ada.web.programacao_web_2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

@SpringBootApplication
@EnableWebSecurity
@EnableMethodSecurity(securedEnabled = true)
public class ProgramacaoWeb2Application {

	public static void main(String[] args) {
		
		SpringApplication.run(ProgramacaoWeb2Application.class, args);
		
	}

}

package com.hmakroum.config.client;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
public class ClientApplication {

	public static void main(String[] args) {
		SpringApplication.run(ClientApplication.class, args);
	}

	@RestController
	@RefreshScope
	class UserController{
		@Value("${user.role:defaultRole}")
		private String role;

		@Value("${user.token:defaultToken}")
		private String token;

		@Value("${user.password:defaultPassword}")
		private String password ;

		@GetMapping(
				value = "/hello/{username}",
				produces = MediaType.TEXT_PLAIN_VALUE)
		public String hello(@PathVariable("username") String username){
			return String.format("Hello! You're %s and you'll become a(n) %s...\n, token is %s and pass is %s", username, role, token, password);
		}
	}

}

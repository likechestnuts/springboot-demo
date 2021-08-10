package com.example.oauth2;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootTest
class Oauth2ApplicationTests {

	@Test
	void contextLoads() {
	}

	public static void main(String[] args) {
		BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();

		System.out.println(bCryptPasswordEncoder.matches("123","$2a$10$Hag4dJF0TDm1BFe9.2/DCeuO3dan/RZMVYn6SBz/GWdCuf9jQam5O"));
		System.out.println(bCryptPasswordEncoder.encode("123"));
	}
}

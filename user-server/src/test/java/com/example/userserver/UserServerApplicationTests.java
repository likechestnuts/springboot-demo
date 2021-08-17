package com.example.userserver;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.time.LocalDateTime;
import java.time.LocalTime;

@SpringBootTest
class UserServerApplicationTests {

	@Test
	void contextLoads() {
		System.out.println(new BCryptPasswordEncoder().encode("OTfyu3w4Jc3V54IL"));
	}

	public static void main(String[] args) {
		System.out.println(LocalDateTime.now());
	}

}

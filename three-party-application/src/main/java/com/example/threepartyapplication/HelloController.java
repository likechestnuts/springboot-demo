/*
 * Copyright (c) 2021, wangguodong. All rights reserved.
 */

package com.example.threepartyapplication;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

/**
 * @author wangguodong
 * @since 2021/8/11
 */
@Controller
public class HelloController {
	@Autowired
	RestTemplate restTemplate;

	@GetMapping("/index.html")
	public String hello(String code, Model model) {
		if (code != null) {
			MultiValueMap<String, String> map = new LinkedMultiValueMap<>();
			map.add("code", code);
			map.add("client_id", "javaboy");
			map.add("client_secret", "123");
			map.add("redirect_uri", "http://localhost:8082/index.html");
			map.add("grant_type", "authorization_code");
			Map<String,String> resp = restTemplate.postForObject("http://localhost:8080/oauth/token", map, Map.class);
			String access_token = resp.get("access_token");
			System.out.println(access_token);
			HttpHeaders headers = new HttpHeaders();
			headers.add("Authorization", "Bearer " + access_token);
			HttpEntity<Object> httpEntity = new HttpEntity<>(headers);
			ResponseEntity<String> entity = restTemplate.exchange("http://localhost:8081/admin/hello", HttpMethod.GET, httpEntity, String.class);
			model.addAttribute("msg", entity.getBody());
		}
		return "index";
	}

	@GetMapping("/simple-index.html")
	public String simple() {
		System.out.println(11);
		return "simple-index";
	}

	@GetMapping("/password.html")
	public String password(String username, String password,Model model) {
		MultiValueMap<String, String> map = new LinkedMultiValueMap<>();
		map.add("username", username);
		map.add("password", password);
		map.add("client_secret", "123");
		map.add("client_id", "javaboy");
		map.add("grant_type", "password");
		Map<String,String> resp = restTemplate.postForObject("http://localhost:8080/oauth/token", map, Map.class);
		String access_token = resp.get("access_token");
		HttpHeaders headers = new HttpHeaders();
		headers.add("Authorization", "Bearer " + access_token);
		HttpEntity<Object> httpEntity = new HttpEntity<>(headers);
		ResponseEntity<String> entity = restTemplate.exchange("http://localhost:8081/admin/hello", HttpMethod.GET, httpEntity, String.class);
		model.addAttribute("msg", entity.getBody());
		return "password";
	}
}
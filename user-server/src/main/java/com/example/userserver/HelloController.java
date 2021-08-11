/*
 * Copyright (c) 2021, wangguodong. All rights reserved.
 */

package com.example.userserver;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author wangguodong
 * @since 2021/8/11
 */
@RestController
public class HelloController {
	@GetMapping("/hello")
	public String hello() {
		return "hello";
	}
	@GetMapping("/admin/hello")
	public String admin() {
		return "admin";
	}
}
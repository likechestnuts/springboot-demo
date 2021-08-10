/*
 * Copyright (c) 2021, wangguodong. All rights reserved.
 */

package com.example.oauth;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

/**
 * @author wangguodong
 * @since 2021/8/10
 */
@Configuration
public class WebSecurityConfiguration extends WebSecurityConfigurerAdapter {

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.csrf().disable().addFilterBefore(weChatAuthenticationFilter(), UsernamePasswordAuthenticationFilter.class)
				.authorizeRequests().antMatchers("/wechat/login").permitAll().anyRequest().hasRole("WECHAT");
	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.authenticationProvider(new WeChatAuthenticationProvider());
	}

	private WeChatAuthenticationFilter weChatAuthenticationFilter() throws Exception {
		WeChatAuthenticationFilter weChatAuthenticationFilter = new WeChatAuthenticationFilter();
		weChatAuthenticationFilter.setAuthenticationManager(authenticationManager());
		return weChatAuthenticationFilter;
	}
}

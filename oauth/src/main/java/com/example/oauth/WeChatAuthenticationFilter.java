/*
 * Copyright (c) 2021, wangguodong. All rights reserved.
 */

package com.example.oauth;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author wangguodong
 * @since 2021/8/10
 */
public class WeChatAuthenticationFilter extends AbstractAuthenticationProcessingFilter {

	protected WeChatAuthenticationFilter() {
		super("/wechat/login");
	}

	protected WeChatAuthenticationFilter(String defaultFilterProcessesUrl) {
		super(defaultFilterProcessesUrl);
	}

	@Override
	public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException, IOException, ServletException {
		String openid = request.getParameter("openid");
		return this.getAuthenticationManager().authenticate(new WeChatAuthenticationToken(openid));
	}
}

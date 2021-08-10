/*
 * Copyright (c) 2021, wangguodong. All rights reserved.
 */

package com.example.oauth;

import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.Arrays;

/**
 * @author wangguodong
 * @since 2021/8/10
 */
public class WeChatAuthenticationProvider implements AuthenticationProvider {
	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {
		WeChatAuthenticationToken weChatAuthenticationToken = new WeChatAuthenticationToken(authentication.getPrincipal(), Arrays.asList(new SimpleGrantedAuthority("ROLE_WECHAT")));
		return weChatAuthenticationToken;
	}

	@Override
	public boolean supports(Class<?> authentication) {
		return authentication.isAssignableFrom(WeChatAuthenticationToken.class);
	}
}

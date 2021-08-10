/*
 * Copyright (c) 2021, wangguodong. All rights reserved.
 */

package com.example.oauth;

import org.springframework.security.authentication.AbstractAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;

/**
 * @author wangguodong
 * @since 2021/8/10
 */
public class WeChatAuthenticationToken extends AbstractAuthenticationToken {

	private Object principal;


	public WeChatAuthenticationToken(Object principal, Collection<? extends GrantedAuthority> authorities) {
		super(authorities);
		this.principal = principal;
	}
	public WeChatAuthenticationToken(Object principal) {
		super(null);
		this.principal = principal;
	}

	@Override
	public Object getCredentials() {
		return null;
	}

	@Override
	public Object getPrincipal() {
		return this.principal;
	}
}

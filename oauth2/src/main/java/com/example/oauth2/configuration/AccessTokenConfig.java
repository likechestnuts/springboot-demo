/*
 * Copyright (c) 2021, wangguodong. All rights reserved.
 */

package com.example.oauth2.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.InMemoryTokenStore;

/**
 * @author wangguodong
 * @since 2021/8/6
 */
public class AccessTokenConfig {
	@Bean
	TokenStore tokenStore() {
		return new InMemoryTokenStore();
	}
}

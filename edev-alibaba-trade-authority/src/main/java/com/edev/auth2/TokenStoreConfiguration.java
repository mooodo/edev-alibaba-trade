package com.edev.auth2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.oauth2.provider.ClientDetailsService;
import org.springframework.security.oauth2.provider.token.AuthorizationServerTokenServices;
import org.springframework.security.oauth2.provider.token.DefaultTokenServices;
import org.springframework.security.oauth2.provider.token.TokenEnhancerChain;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.store.jwk.JwkTokenStore;

import java.util.Collections;

@Configuration
public class TokenStoreConfiguration {
    @Autowired
    private ClientDetailsService clientDetailsService;
    @Bean
    public AuthorizationServerTokenServices tokenServices() {
        DefaultTokenServices tokenServices = new DefaultTokenServices();
        tokenServices.setClientDetailsService(clientDetailsService);
        tokenServices.setSupportRefreshToken(true);
        tokenServices.setTokenStore(tokenStore());
        TokenEnhancerChain tokenEnhancerChain = new TokenEnhancerChain();
        tokenEnhancerChain.setTokenEnhancers(Collections.singletonList(jwtAccessTokenConverter()));
        tokenServices.setTokenEnhancer(tokenEnhancerChain);
        return tokenServices;
    }
    @Bean
    public TokenStore tokenStore() {
        String jwkSetUrl = "https://my-org.oktapreview.com/oauth2/my-auth-server/v1/keys";
        return new JwkTokenStore(jwkSetUrl, jwtAccessTokenConverter());
    }

    @Bean
    public JwtAccessTokenConverter jwtAccessTokenConverter() {
        JwtAccessTokenConverter jwtAccessTokenConverter = new JwtAccessTokenConverter();
        String sign_key = "123";
        jwtAccessTokenConverter.setSigningKey(sign_key);
        return jwtAccessTokenConverter;
    }
}

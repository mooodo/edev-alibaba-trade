package com.edev.auth2.security.entity;

import com.edev.auth2.authority.entity.Authority;
import org.springframework.security.core.GrantedAuthority;

public class DefaultGrantedAuthority implements GrantedAuthority {
    private final Authority authority;
    public DefaultGrantedAuthority(Authority authority) {
        this.authority = authority;
    }
    @Override
    public String getAuthority() {
        return authority.getName();
    }
}

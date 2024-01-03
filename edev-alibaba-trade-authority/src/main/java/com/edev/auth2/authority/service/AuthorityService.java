package com.edev.auth2.authority.service;

import com.edev.auth2.authority.entity.Authority;

public interface AuthorityService {
    Long createAuthority(Authority authority);
    void modifyAuthority(Authority authority);
    void deleteAuthority(Long id);
    Authority getAuthority(Long id);
}

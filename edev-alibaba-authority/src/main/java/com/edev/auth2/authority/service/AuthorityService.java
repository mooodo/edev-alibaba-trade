package com.edev.auth2.authority.service;

import com.edev.auth2.authority.entity.Authority;

public interface AuthorityService {
    Long create(Authority authority);
    void modify(Authority authority);
    void remove(Long authorityId);
    Authority load(Long authorityId);
}

package com.edev.auth2.authority.service.impl;

import com.edev.auth2.authority.entity.Authority;
import com.edev.auth2.authority.service.AuthorityService;
import com.edev.support.dao.BasicDao;
import lombok.NonNull;

public class AuthorityServiceImpl implements AuthorityService {
    private final BasicDao dao;

    public AuthorityServiceImpl(BasicDao dao) {
        this.dao = dao;
    }
    @Override
    public Long createAuthority(@NonNull Authority authority) {
        return dao.insert(authority);
    }

    @Override
    public void modifyAuthority(@NonNull Authority authority) {
        dao.update(authority);
    }

    @Override
    public void deleteAuthority(@NonNull Long id) {
        dao.delete(id, Authority.class);
    }

    @Override
    public Authority getAuthority(@NonNull Long id) {
        return dao.load(id, Authority.class);
    }
}

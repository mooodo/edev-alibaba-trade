package com.edev.auth2.authority.service;

import com.edev.auth2.authority.entity.Role;

public interface RoleService {
    Long create(Role role);
    void modify(Role role);
    void remove(Long roleId);
    Role load(Long roleId);
    Role loadByName(String roleName);
}

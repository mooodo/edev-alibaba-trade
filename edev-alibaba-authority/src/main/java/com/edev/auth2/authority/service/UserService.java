package com.edev.auth2.authority.service;

import com.edev.auth2.authority.entity.User;

public interface UserService {
    Long register(User user);
    void modify(User user);
    void remove(Long userId);
    User load(Long userId);
    void removeByName(String username);
    User loadByName(String username);
    public boolean userExists(String username);
}

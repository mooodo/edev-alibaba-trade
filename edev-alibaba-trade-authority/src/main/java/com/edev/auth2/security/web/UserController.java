package com.edev.auth2.security.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class UserController {
    @Autowired
    private UserDetailsService userDetailsService;
    @RequestMapping(value = "userinfo", produces = "application/json")
    public Map<String, Object> userinfo(UsernamePasswordAuthenticationToken token) {
        Map<String, Object> map = new HashMap<>();
        UserDetails userDetails = userDetailsService.loadUserByUsername((String) token.getPrincipal());
        map.put("user", userDetails);
        map.put("authorities", token.getAuthorities());
        return map;
    }
}

package com.edev.auth2.authority.web;

import com.edev.auth2.authority.entity.Authority;
import com.edev.auth2.authority.service.AuthorityService;
import com.edev.support.entity.ResultSet;
import com.edev.support.query.QueryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("authority")
public class AuthorityController {
    @Autowired
    private AuthorityService service;
    @PostMapping("create")
    @PreAuthorize("(hasRole('administrator')) or (hasAuthority('createAuthority'))")
    public Long create(@RequestBody Authority authority) {
        return service.create(authority);
    }
    @PostMapping("modify")
    @PreAuthorize("(hasRole('administrator')) or (hasAuthority('modifyAuthority'))")
    public void modify(@RequestBody Authority authority) {
        service.modify(authority);
    }
    @GetMapping("remove")
    @PreAuthorize("(hasRole('administrator')) or (hasAuthority('removeAuthority'))")
    public void remove(Long authorityId) {
        service.remove(authorityId);
    }
    @GetMapping("load")
    @PreAuthorize("(hasRole('administrator')) or (hasAuthority('loadAuthority'))")
    public Authority load(Long authorityId) {
        return service.load(authorityId);
    }
    @Autowired @Qualifier("authorityQry")
    private QueryService queryService;
    @PostMapping("query")
    @PreAuthorize("(hasRole('administrator')) or (hasAuthority('queryAuthority'))")
    public ResultSet query(Map<String, Object> params) {
        return queryService.query(params);
    }
}

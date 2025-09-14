package com.edev.auth2.authority.web;

import com.edev.auth2.authority.entity.Role;
import com.edev.auth2.authority.service.RoleService;
import com.edev.support.entity.ResultSet;
import com.edev.support.query.QueryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("role")
public class RoleController {
    @Autowired
    private RoleService service;
    @PostMapping("create")
    @PreAuthorize("(hasRole('administrator')) or (hasAuthority('createRole'))")
    public Long create(@RequestBody Role role) {
        return service.create(role);
    }
    @PostMapping("modify")
    @PreAuthorize("(hasRole('administrator')) or (hasAuthority('modifyRole'))")
    public void modify(@RequestBody Role role) {
        service.modify(role);
    }
    @GetMapping("remove")
    @PreAuthorize("(hasRole('administrator')) or (hasAuthority('removeRole'))")
    public void remove(Long roleId) {
        service.remove(roleId);
    }
    @GetMapping("load")
    @PreAuthorize("(hasRole('administrator')) or (hasAuthority('loadRole'))")
    public Role load(Long roleId) {
        return service.load(roleId);
    }
    @Autowired @Qualifier("roleQry")
    private QueryService queryService;
    @PostMapping("query")
    @PreAuthorize("(hasRole('administrator')) or (hasAuthority('queryRole'))")
    public ResultSet query(Map<String,Object> params) {
        return queryService.query(params);
    }
}

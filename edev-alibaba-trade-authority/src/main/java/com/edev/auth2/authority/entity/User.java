package com.edev.auth2.authority.entity;

import com.edev.support.entity.Entity;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.ArrayList;
import java.util.List;

@Data
@EqualsAndHashCode(callSuper = true)
public class User extends Entity<Long> {
    private Long id;
    private String name;
    private String password;
    private int accountExpired;
    private int accountLocked;
    private int credentialsExpired;
    private int disabled;
    private List<Authority> authorities = new ArrayList<>();
    private List<Role> roles = new ArrayList<>();

    public static User build() {
        return new User();
    }

    public User setValues(Long id, String name, String password) {
        this.id = id;
        this.name = name;
        this.password = password;
        return this;
    }

    public Boolean isAccountExpired() {
        return accountExpired!=0;
    }

    public void setAccountExpired(Boolean accountExpired) {
        this.accountExpired = (accountExpired ? 1 : 0);
    }

    public Boolean isAccountLocked() {
        return accountLocked!=0;
    }

    public void setAccountLocked(Boolean accountLocked) {
        this.accountLocked = (accountLocked ? 1 : 0);
    }

    public Boolean isCredentialsExpired() {
        return credentialsExpired!=0;
    }

    public void setCredentialsExpired(Boolean credentialsExpired) {
        this.credentialsExpired = (credentialsExpired ? 1 : 0);
    }

    public Boolean isDisabled() {
        return disabled!=0;
    }

    public void setDisabled(Boolean disabled) {
        this.disabled = (disabled ? 1 : 0);
    }

    public void addAuthority(Authority authority) {
        this.authorities.add(authority);
    }

    public void addRole(Role role) {
        this.roles.add(role);
    }
}

package com.example.Banking.configuration;

import com.example.Banking.model.Authority;
import com.example.Banking.model.Role;
import com.example.Banking.model.User;
import com.example.Banking.model.UserRole;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.*;

public class CustomUserDetail implements UserDetails {

    private User user;
    private HashMap<Object, Object> userRoles;

    public CustomUserDetail(User user){
        this.user = user;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        Set<UserRole> roles = user.getUserRoles();
        List<Authority> authorities = new ArrayList<>();
        for (UserRole role: roles){
            authorities.add(new Authority(role.getRole().getRoleName()));
        }
        return authorities;
    }

//        @Override
//    public Collection<? extends GrantedAuthority> getAuthorities() {
//        Set<Authority> set = new HashSet<>();
//        this.userRoles.forEach(userRole -> {
//            set.add(new Authority(userRole.getRole().getRoleName()));
//        });
//        return set;
//    }

    @Override
    public String getPassword() {
        return user.getUserPassword();
    }

    @Override
    public String getUsername() {
        return user.getUserName();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}

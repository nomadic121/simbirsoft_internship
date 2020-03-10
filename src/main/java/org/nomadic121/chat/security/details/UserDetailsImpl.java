package org.nomadic121.chat.security.details;

import org.nomadic121.chat.entity.Role;
import org.nomadic121.chat.entity.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Collections;

public class UserDetailsImpl implements UserDetails {

    private Long id;

    private String name;

    private String hashPass;

    private Role roles;

    public UserDetailsImpl(User user) {
        this.id = user.getId();
        this.name = user.getName();
        this.hashPass = user.getHashPass();
        this.roles = user.getRoles();
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getHashPass() {
        return hashPass;
    }

    public Role getRoles() {
        return roles;
    }

    @Override
    public String getUsername() {
        return this.name;
    }

    @Override
    public String getPassword() {
        return this.hashPass;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Collections.singleton(new SimpleGrantedAuthority(
                this.roles.toString()));
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

package org.nomadic121.chat.security.details;

import lombok.NonNull;
import org.nomadic121.chat.entity.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;

public class UserDetailsImpl implements UserDetails {

    private Long id;

    private String name;

    private String hashPass;

    public UserDetailsImpl(User user) {
        this.id = user.getId();
        this.name = user.getName();
        this.hashPass = user.getHashPass();
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

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public String getPassword() {
        return this.hashPass;
    }

    @Override
    public String getUsername() {
        return this.name;
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

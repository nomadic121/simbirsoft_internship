package org.nomadic121.chat.security.details;

import org.nomadic121.chat.entity.Role;
import org.nomadic121.chat.entity.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

public class UserDetailsImpl implements UserDetails {

    private Long id;

    private String userName;

    private String password;

    private Set<SimpleGrantedAuthority> authorities;

    public UserDetailsImpl(User user) {
        this.id = user.getId();
        this.userName = user.getUserName();
        this.password = user.getPassword();
        this.authorities = new HashSet<>();
        for (Role userAuthority : user.getAuthorities()) {
            this.authorities.add(new SimpleGrantedAuthority(userAuthority.toString()));
        }
    }

    public Long getId() {
        return id;
    }

    @Override
    public String getUsername() {
        return this.userName;
    }

    @Override
    public String getPassword() {
        return this.password;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return this.authorities;
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

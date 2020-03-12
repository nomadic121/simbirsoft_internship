package org.nomadic121.chat.service;

import org.nomadic121.chat.entity.User;
import org.springframework.security.core.Authentication;

public interface AuthenticationService {
    User getUserByAuthentication(Authentication authentication);
}

package org.nomadic121.chat.util;

import org.nomadic121.chat.entity.Role;

import java.util.HashSet;
import java.util.Set;

public enum RoleAuthoritiesManager {

    USER(Role.ROLE_USER),
    ADMINISTRATOR(Role.ROLE_ADMINISTRATOR),
    MODERATOR(Role.ROLE_MODERATOR),
    BANNED(Role.BANNED);

    public Set<Role> getAuthorities() {
        return authorities;
    }

    private final Set<Role> authorities = new HashSet<>();

    RoleAuthoritiesManager(Role role) {
        switch (role) {
            case BANNED:
                authorities.add(Role.ROLE_USER);
                authorities.add(Role.CAN_GET_MESSAGES);
                authorities.add(Role.BANNED);
                break;
            case ROLE_ADMINISTRATOR:
                authorities.add(Role.ROLE_ADMINISTRATOR);
                authorities.add(Role.CAN_GET_MESSAGES);
                authorities.add(Role.CAN_SEND_MESSAGES);
                break;
            case ROLE_MODERATOR:
                authorities.add(Role.ROLE_MODERATOR);
                authorities.add(Role.CAN_EDIT_AND_DELETE_MESSAGES);
                authorities.add(Role.CAN_GET_MESSAGES);
                authorities.add(Role.CAN_SEND_MESSAGES);
                break;
            case ROLE_USER:
                authorities.add(Role.ROLE_USER);
                authorities.add(Role.CAN_GET_MESSAGES);
                authorities.add(Role.CAN_SEND_MESSAGES);
                break;
            default:
                break;
        }
    }

}
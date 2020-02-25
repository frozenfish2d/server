package org.frozenfish.enums;

import org.springframework.security.core.GrantedAuthority;

public enum  Role implements GrantedAuthority {
    USER,
    ADMIN,
    DOCTOR;

    @Override
    public String getAuthority() {
        return name();
    }
}

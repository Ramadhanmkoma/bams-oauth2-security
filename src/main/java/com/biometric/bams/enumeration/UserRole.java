package com.biometric.bams.enumeration;

import lombok.RequiredArgsConstructor;

//@RequiredArgsConstructor
public enum UserRole {
    ROLE_STUDENT("ROLE_STUDENT"),
    ROLE_LECTURER("ROLE_LECTURER"),
    ROLE_ADMIN("ROLE_ADMIN"),
    ROLE_HR("ROLE_HR");

    private final String roleName;

    UserRole(String roleName) {
        this.roleName = roleName;
    }

    public String getRoleName() {
        return this.roleName;
    }

}

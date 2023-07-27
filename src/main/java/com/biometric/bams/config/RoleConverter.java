package com.biometric.bams.config;

import com.biometric.bams.enumeration.UserRole;
import jakarta.persistence.AttributeConverter;

public class RoleConverter implements AttributeConverter<UserRole, String> {
    @Override
    public String convertToDatabaseColumn(UserRole role) {
        return role.name();
    }

    @Override
    public UserRole convertToEntityAttribute(String roleName) {
        return UserRole.valueOf(roleName);
    }
}

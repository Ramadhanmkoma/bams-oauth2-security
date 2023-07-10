package com.biometric.bams.enumeration;

import jakarta.persistence.*;
import lombok.Data;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Ramadhan Mohammed Mkoma (<a href="http://www.ramadhanmkoma.me/">RamadhanMkoma</a>)
 * @version 1.0
 * @since 07/07/2023
 */
public enum Role {
    HR,
    LECTURER,
    ADMIN
}

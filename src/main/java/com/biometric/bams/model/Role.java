package com.biometric.bams.model;

import com.biometric.bams.enumeration.UserRole;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;

import java.util.HashSet;
import java.util.Set;

/**
 * @author: Ramadhan Mohammed
 * @website: <a href="http://ramadhanmkoma.me">Ramadhan</a>
 * @createdDate: Thursday, 20 July 2023
 * @latestModifiedDate: Thursday, 27 July 2023
 */
@Data
@Entity
@Table(name = "bams_roles")
@NoArgsConstructor
@AllArgsConstructor
public class Role implements GrantedAuthority {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Enumerated(EnumType.STRING)
    @Column(unique = true)
    private UserRole name;
    private String permissions;

//    @ManyToMany(mappedBy = "roles")
//    private Set<User> users = new HashSet<>();

    @Override
    public String getAuthority() {
        return this.permissions;
    }
}

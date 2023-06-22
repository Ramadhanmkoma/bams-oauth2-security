package com.biometric.bams.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.Type;

import java.sql.Date;
import java.util.HashSet;
import java.util.Set;

@Data
@Entity(name = "bams_lecturer")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Lecturer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long lecturer_id;

    private String fname;

    private String lname;

    private String phone;

    private String email;

    private Date dob;

    private Character gender;

    @ManyToOne
    @JoinColumn(name = "department")
    private Department department;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "user_role",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id")
    )
    private Set<Role> roles = new HashSet<>();

    @Lob
    private Byte[] profile_image;
}

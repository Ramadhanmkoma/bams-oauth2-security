package com.biometric.bams.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;


/**
 * @author Ramadhan Mohammed Mkoma (<a href="http://www.ramadhanmkoma.me/">RamadhanMkoma</a>)
 * @version 1.0
 * @since 07/2023
 */
@Data
@Entity
@Table(name = "bams_students")
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class Student extends User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty(message = "registration number cannot be empty")
    @Column(nullable = false, unique = true)
    private String regNo;

    @NotEmpty(message = "Department cannot be empty")
    @Column(nullable = false)
    private String department;

    @Column(nullable = false)
        private String batch;

    @OneToOne(mappedBy = "student", cascade = CascadeType.ALL)
    private BiometricRecord biometricRecord;

}

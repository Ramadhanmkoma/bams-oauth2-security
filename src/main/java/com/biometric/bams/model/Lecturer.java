package com.biometric.bams.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import lombok.*;

/**
 * @author: Ramadhan Mohammed
 * @website: <a href="http://ramadhanmkoma.me">Ramadhan</a>
 * @createdDate: Thursday, 20 July 2023
 */
@Data
@Builder
@Entity
@Table(name = "bams_lecturers")
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class Lecturer extends User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty(message = "Lecturer ID cannot be empty")
    @Column(nullable = false, unique = true)
    private String lectId;

    @NotEmpty(message = "Department cannot be empty")
    @Column(nullable = false)
    private String department;

    @NotEmpty(message = "cannot be empty")
    @Column(nullable = false)
    private String subjectTaught;

    @OneToOne(mappedBy = "lecturer", cascade = CascadeType.ALL)
    private BiometricRecord biometricRecord;
}

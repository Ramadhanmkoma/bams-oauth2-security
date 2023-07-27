package com.biometric.bams.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Table(name = "bams_biometric_records")
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class BiometricRecord {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Lob
    @Column(nullable = false)
    private byte[] biometricData;

    @OneToOne
    @JoinColumn(name = "student_id", referencedColumnName = "id")
    private Student student;

    @OneToOne
    @JoinColumn(name = "lecturer_id", referencedColumnName = "id")
    private Lecturer lecturer;
}

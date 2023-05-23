package com.biometric.bams.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity(name = "bams_student_fingerprint")
public class StudentFingerprint {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long finger_id;

    private Byte[] fingerprint_recog;


}

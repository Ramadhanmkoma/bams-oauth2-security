package com.biometric.bams.repository;

import com.biometric.bams.model.StudentFingerprint;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentFingerprintRepo extends JpaRepository<StudentFingerprint, Long> {
}

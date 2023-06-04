package com.biometric.bams.repository;

import com.biometric.bams.model.LecturerFingerprint;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LecturerFingerprintRepo extends JpaRepository<LecturerFingerprint, Long> {
}

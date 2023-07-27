package com.biometric.bams.repository;

import com.biometric.bams.model.BiometricRecord;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BiometricRecordRepo extends JpaRepository<BiometricRecord, Long> {
}

package com.biometric.bams.repository;

import com.biometric.bams.model.HR;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HRRepository extends JpaRepository<HR, Long> {
}

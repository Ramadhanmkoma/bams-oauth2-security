package com.biometric.bams.repository;

import com.biometric.bams.model.ClassInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClassInfoRepo extends JpaRepository<ClassInfo, Integer> {
}

package com.biometric.bams.repository;

import com.biometric.bams.model.Lecturer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LecturerRepo extends JpaRepository<Lecturer, Long> {
}

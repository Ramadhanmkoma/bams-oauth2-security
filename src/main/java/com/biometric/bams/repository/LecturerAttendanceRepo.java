package com.biometric.bams.repository;

import com.biometric.bams.model.LecturerAttendance;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LecturerAttendanceRepo extends JpaRepository<LecturerAttendance, Integer> {
}

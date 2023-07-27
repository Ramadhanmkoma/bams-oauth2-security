package com.biometric.bams.repository;

import com.biometric.bams.model.StudAttendanceRecord;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudAttendanceRecordRepo extends JpaRepository<StudAttendanceRecord, Long> {
}

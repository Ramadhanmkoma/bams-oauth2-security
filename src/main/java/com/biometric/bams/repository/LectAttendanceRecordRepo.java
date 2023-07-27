package com.biometric.bams.repository;

import com.biometric.bams.model.LectAttendanceRecord;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LectAttendanceRecordRepo extends JpaRepository<LectAttendanceRecord, Long> {
}

package com.biometric.bams.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity(name = "bams_lecturer_attendance")
public class LecturerAttendance extends Attendance {
    @Id
    @GeneratedValue
    private Integer lect_att_id;
}

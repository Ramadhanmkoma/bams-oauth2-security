package com.biometric.bams.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity(name = "bams_student_attendance")
public class StudentAttendance extends Attendance {

    @Id
    @GeneratedValue
    private Integer stud_att_id;
}

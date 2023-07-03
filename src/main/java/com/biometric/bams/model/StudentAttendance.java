package com.biometric.bams.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;

import java.sql.Date;
import java.sql.Time;

@Data
@Entity(name = "bams_student_attendance")
public class StudentAttendance extends Attendance {

    @Id
    @GeneratedValue
    private Integer att_id;

    private Date attendance_date;
    private String day;
    private Time time_in;
    private Time time_out;
    private String attendance_status;

}

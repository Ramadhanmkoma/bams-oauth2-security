package com.biometric.bams.model;

import lombok.Data;

import java.sql.Date;
import java.sql.Time;

@Data
public class Attendance {
    private Date attendance_date;
    private String day;
    private Time time_in;
    private Time time_out;
    private String attendance_status;

}

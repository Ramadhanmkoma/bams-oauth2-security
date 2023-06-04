package com.biometric.bams.model;

import lombok.Data;

import java.sql.Date;

@Data
public class Attendance {

    private String attendance_status;

    private Date attendance_date;

}

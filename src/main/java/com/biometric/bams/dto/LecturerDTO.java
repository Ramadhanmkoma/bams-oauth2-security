package com.biometric.bams.dto;

import java.sql.Date;
import java.util.Set;

public class LecturerDTO {
    private String fname;
    private String lname;
    private String phone;
    private String email;
    private Date dob;
    private Character gender;
    private Set<Long> roleIds;
}

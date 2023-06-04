package com.biometric.bams.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.Type;

import java.sql.Date;

@Data
@Entity(name = "bams_lecturer")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Lecturer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long lecturer_id;

    private String fname;

    private String lname;

    private String phone;

    private String email;

    private Date dob;

    private Character gender;


    @Lob
    private Byte[] profile_image;
}

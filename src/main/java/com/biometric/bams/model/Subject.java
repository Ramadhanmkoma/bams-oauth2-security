package com.biometric.bams.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity(name = "bams_subject")
public class Subject {

    @Id
    @GeneratedValue
    private Long sub_id;

    private String sub_code;

    private String sub_name;
}

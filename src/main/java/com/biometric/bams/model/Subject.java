package com.biometric.bams.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@Entity(name = "bams_subjects")
@NoArgsConstructor
@AllArgsConstructor
public class Subject {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long sub_id;
    private String sub_code;
    private String sub_name;
    @OneToMany(mappedBy = "subject", cascade = CascadeType.ALL)
    private List<Session> sessions = new ArrayList<>();
}

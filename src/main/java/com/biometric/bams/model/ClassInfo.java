package com.biometric.bams.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * @author: Ramadhan Mohammed
 * @website: <a href="http://ramadhanmkoma.me">Ramadhan</a>
 * @createdDate: Thursday, 20 July 2023
 */
@Data
@Entity
@Table(name = "bams_classinfos")
public class ClassInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "stud_id", nullable = false)
    private Student student;

    @ManyToOne
    @JoinColumn(name = "lect_id", nullable = false)
    private Lecturer lecturer;

    @Column(nullable = false)
    private LocalDate date;

    @Column(nullable = false)
    private boolean present;

    @OneToMany(mappedBy = "classInfo", cascade = CascadeType.ALL)
    private List<Session> sessions = new ArrayList<>();

}

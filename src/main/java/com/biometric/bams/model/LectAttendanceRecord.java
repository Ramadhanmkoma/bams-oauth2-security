package com.biometric.bams.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

/**
 * @author: Ramadhan Mohammed
 * @website: <a href="http://ramadhanmkoma.me">Ramadhan</a>
 * @createdDate: Thursday, 20 July 2023
 */
@Data
@Entity
@Table(name = "bams_lect_attendances")
@AllArgsConstructor
@NoArgsConstructor
public class LectAttendanceRecord {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "lect_id", nullable = false)
    private Lecturer lecturer;

    @ManyToOne
    @JoinColumn(name = "class_id", nullable = false)
    private ClassInfo classInfo;

    @Column(nullable = false)
    private LocalDate date;

    @Column(nullable = false)
    private boolean present;

    @ManyToOne
    @JoinColumn(name = "session_id", nullable = false)
    private Session session;
}

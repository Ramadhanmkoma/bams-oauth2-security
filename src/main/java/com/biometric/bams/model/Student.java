package com.biometric.bams.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Data
@Entity(name = "bams_student")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long stud_id;

    private String studReg_no;

    private String fname;

    private String lname;

    private String phone_no;

    private String email;

    private LocalDate dob;

    private Character gender;

    @OneToOne(mappedBy = "student", cascade = CascadeType.ALL)
    private StudentFingerprint studentFingerprint;

    @ManyToOne
    @JoinColumn(name = "department")
    private Department department;

    //    many - many relationship implementation
    @ManyToMany
    @JoinTable(
            name = "bams_student_classInfo",
            joinColumns = @JoinColumn(name = "stud_id"),
            inverseJoinColumns = @JoinColumn(name = "classId"))
    private List<ClassInfo> classInfo;

    public List<ClassInfo> getClassInfo() {
        return classInfo;
    }

    public void setClassInfo(List<ClassInfo> classInfo) {
        this.classInfo = classInfo;
    }

}

package com.biometric.bams.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.time.Period;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Data
@Entity(name = "bams_student")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Student {

    @Id
    @SequenceGenerator(
            name = "student_sequence",
            sequenceName = "student_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "student_sequence"
    )
    private Long stud_id;

    private String studReg_no;

    private String fname;

    private String lname;

    private String phone_no;

    private String email;

    private LocalDate dob;

    @Transient
    private Integer age;

    private Character gender;

    public Student() {
    }

    public Student(String studReg_no, String fname, String lname, String phone_no, String email, LocalDate dob, Character gender) {
        this.studReg_no = studReg_no;
        this.fname = fname;
        this.lname = lname;
        this.phone_no = phone_no;
        this.email = email;
        this.dob = dob;
        this.gender = gender;
    }

    public Integer getAge() {
        return Period.between(this.dob, LocalDate.now()).getYears();
    }

    public void setAge(Integer age) {
        this.age = age;
    }

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

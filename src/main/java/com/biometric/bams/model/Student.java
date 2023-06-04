package com.biometric.bams.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Data;

import java.sql.Date;
import java.util.List;

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

    private Date dob;

    private Character gender;


    //    many - many relationship implementation
    @ManyToMany
    @JoinTable(
            name = "bams_student_classInfo",
            joinColumns = @JoinColumn(name = "stud_id"),
            inverseJoinColumns = @JoinColumn(name = "classId")
    )
    private List<ClassInfo> classInfo;

    public List<ClassInfo> getClassInfo() {
        return classInfo;
    }

    public void setClassInfo(List<ClassInfo> classInfo) {
        this.classInfo = classInfo;
    }




}

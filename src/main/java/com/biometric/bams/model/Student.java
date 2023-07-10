package com.biometric.bams.model;

import com.biometric.bams.enumeration.Status;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.Period;
import java.util.List;


/**
 * @author Ramadhan Mohammed Mkoma (<a href="http://www.ramadhanmkoma.me/">RamadhanMkoma</a>)
 * @version 1.0
 * @since 07/2023
 */
@Data
@Builder
@Entity(name = "bams_student")
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long stud_id;

    @Column(unique = true)
    @NotEmpty(message = "Registration number Cannot be empty or null")
    private String regNo;
    private String fname;
    private String lname;
    private String phone_no;

    @Column(unique = true)
    @NotEmpty(message = "Email Address Cannot be empty or null")
    private String email;
    private LocalDate dob;
    private Status status;

    @Transient
    private Integer age;
    private Character gender;


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

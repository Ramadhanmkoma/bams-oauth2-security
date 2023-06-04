package com.biometric.bams.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity(name = "bams_classinfo")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class ClassInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer class_id;

    private Integer class_schedID;


    @ManyToMany(mappedBy = "classInfo")
    @JsonIgnore //serialization
    private List<Student> students;

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }



}

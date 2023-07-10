package com.biometric.bams.service;

import com.biometric.bams.model.Student;

import java.util.Collection;

public interface StudentService {
    Student create(Student student);
    Collection<Student> list(int limit);
    Student get(Long id);
    Student update(Student student);
    Boolean delete(Long id);
    Student markAttendance(String regNo);
    Student email(String email);
}

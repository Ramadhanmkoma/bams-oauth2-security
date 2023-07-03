package com.biometric.bams.service;

import com.biometric.bams.model.Student;
import com.biometric.bams.repository.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.List;

@Service
public class StudentService {

    private final StudentRepo studentRepo;

    @Autowired
    public StudentService(StudentRepo studentRepo) {
        this.studentRepo = studentRepo;
    }

    public List<Student> getStudents() { return studentRepo.findAll(); }

    public Student registerStudent(Student student) {
        return studentRepo.saveAndFlush(student);
    }
}

package com.biometric.bams.service.implementation;

import com.biometric.bams.exception.ApiException;
import com.biometric.bams.model.Student;
import com.biometric.bams.model.User;
import com.biometric.bams.repository.StudentRepo;
import com.biometric.bams.service.StudentService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Optional;

/**
 * @author: Ramadhan Mohammed
 * @website: <a href="http://ramadhanmkoma.me">Ramadhan</a>
 * @createdDate: Tuesday, 25 July 2023
 */
@RequiredArgsConstructor
@Service
@Transactional
@Slf4j
public class StudentServiceImpl implements StudentService {
    private final StudentRepo studentRepo;
    private final BCryptPasswordEncoder passwordEncoder;

    public Collection<User> list() {
        return studentRepo.findAll();
    }

    @Override
    public Student getEmail(String email) {
        Optional<Student> studEmail = studentRepo.findStudentByEmail(email);
        return studEmail.orElseThrow(() -> new ApiException("Student with email "));
    }

    @Override
    public Optional<Student> getUsername(String uname) {
        return studentRepo.findStudentByUsername(uname);
    }

    @Override
    public Optional<Student> getRegNo(String regNo) {
        return studentRepo.findByRegNo(regNo);
    }

    @Override
    public Optional<Student> getOne(Long id) {
        return studentRepo.findStudentById(id);
    }

    @Override
    public Student update(Long id, Student student) {
        log.info("Updating a student with id {} and username {}", id, student.getUsername());
        if (studentRepo.findById(id).isPresent()) {
            student.setId(id);
            return studentRepo.save(student);
        } else {
            return null;
        }
    }

    public Student create(Student student) {
        Optional<Student> username = studentRepo.findStudentByUsername(student.getUsername());
        Optional<Student> email = studentRepo.findStudentByEmail(student.getEmail());
        if (username.isPresent() || email.isPresent()) throw new ApiException("Username or Email already taken. Please! Use a different username");

        try {
            log.info("Creating a new student... with username {}", student.getUsername());
            student.setImageUrl(setStudentImageUrl());
            //student.setRole(ROLE_STUDENT);
            student.setPassword(passwordEncoder.encode(student.getPassword()));
            return studentRepo.saveAndFlush(student);
        } catch (Exception e) {
            log.info(e.getMessage());
            throw new ApiException("Error Occured!");
        }
    }

    public void delete(Long id) {
        log.info("Deleting student with id {}", id);
        studentRepo.deleteById(id);
    }

    private String setStudentImageUrl() {
        return "https://cdn-icons-png.flaticon.com/256/57/57073.png";
    }
}

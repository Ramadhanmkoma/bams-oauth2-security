package com.biometric.bams.service;

import com.biometric.bams.model.Student;
import com.biometric.bams.model.User;

import java.util.Collection;
import java.util.Optional;

/**
 * @author: Ramadhan Mohammed
 * @website: <a href="http://ramadhanmkoma.me">Ramadhan</a>
 * @createdDate: Thursday, 20 July 2023
 */
public interface StudentService {
    Student create(Student student);
    Collection<User> list();
    User getEmail(String email);
    Optional<Student> getUsername(String uname);
    Optional<Student> getRegNo(String regNo);
    Optional<Student> getOne(Long id);
    Student update(Long id, Student student);
    void delete(Long id);

}

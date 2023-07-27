package com.biometric.bams.repository;

import com.biometric.bams.model.Student;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * @author Ramadhan Mohammed Mkoma (<a href="http://www.ramadhanmkoma.me/">RamadhanMkoma</a>)
 * @version 1.0
 * @since 07/2023
 */
@Repository
public interface StudentRepo extends UserRepository {
    Optional<Student> findStudentByEmail(String email);
    Optional<Student> findByRegNo(String regNo);
    Optional<Student> findStudentByUsername(String username);

}

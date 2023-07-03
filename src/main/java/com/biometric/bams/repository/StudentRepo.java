package com.biometric.bams.repository;

import com.biometric.bams.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface StudentRepo
        extends JpaRepository<Student, Long> {

    // Find User By Email -> Construct the query based
    // SELECT * FROM student WHERE email = what we pass
    @Query("SELECT s FROM Student s WHERE s.email = ?1")
    Optional<Student> findStudentByEmail(String email);
}

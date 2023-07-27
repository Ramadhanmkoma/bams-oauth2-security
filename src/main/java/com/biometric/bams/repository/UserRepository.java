package com.biometric.bams.repository;

import com.biometric.bams.model.Lecturer;
import com.biometric.bams.model.Student;
import com.biometric.bams.model.User;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
@Primary
public interface UserRepository extends JpaRepository<User, Long>{
    Optional<User> findByUsername(String username);
    Optional<User> findByEmail(String email);
    Optional<Student> findStudentById(Long id);
    Optional<Lecturer> findLecturerById(Long id);
}

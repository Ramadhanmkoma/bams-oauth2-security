package com.biometric.bams.repository;

import com.biometric.bams.model.Lecturer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface LecturerRepo extends UserRepository {
//    Optional<Lecturer> findLecturerByEmail(String email);
}

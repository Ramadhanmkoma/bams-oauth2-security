package com.biometric.bams.service.implementation;

import com.biometric.bams.model.Lecturer;
import com.biometric.bams.repository.LecturerRepo;
import com.biometric.bams.service.LecturerService;
import com.biometric.bams.service.exceptions.EmailNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Optional;
import java.util.UUID;

/**
 * @author Ramadhan Mohammed Mkoma (<a href="http://www.ramadhanmkoma.me/">RamadhanMkoma</a>)
 * @version 1.0
 * @since 07/2023
 */
@Service
@RequiredArgsConstructor
public class LecturerServiceImpl implements LecturerService {
    @Autowired
    private final LecturerRepo lecturerRepo;

    @Override
    public Lecturer create(Lecturer lecturer) {
        lecturer.setLecturerCode(UUID.randomUUID().toString());
        return lecturerRepo.saveAndFlush(lecturer);
    }

    @Override
    public Collection<Lecturer> list() {
        return lecturerRepo.findAll();
    }

    @Override
    public Lecturer get(Long id) {
        Optional<Lecturer> lecturer = lecturerRepo.findById(id);
        return lecturer.orElseThrow(() -> new IllegalStateException("User with id " + id + " was not found!"));
    }

    @Override
    public Lecturer update(Long id, Lecturer lecturer) {
        return lecturerRepo.save(lecturer);
    }

    @Override
    public void delete(Long id) {
        lecturerRepo.deleteById(id);
    }

    public Lecturer getByEmail(String email) {
        Optional<Lecturer> lecturer = lecturerRepo.findLecturerByEmail(email);
        return lecturer.orElseThrow(() -> new EmailNotFoundException("User with email " + email + " was not found"));
    }
}

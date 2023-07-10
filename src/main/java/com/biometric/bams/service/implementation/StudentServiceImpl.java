package com.biometric.bams.service.implementation;

import com.biometric.bams.model.Student;
import com.biometric.bams.repository.StudentRepo;
import com.biometric.bams.service.StudentService;
import com.biometric.bams.service.exceptions.EmailNotFoundException;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Optional;

import static com.biometric.bams.enumeration.Status.ATTENDED;
import static com.biometric.bams.enumeration.Status.MISSED;
import static java.lang.Boolean.TRUE;
import static org.springframework.data.domain.PageRequest.of;

/**
 * @author Ramadhan Mohammed Mkoma (<a href="http://www.ramadhanmkoma.me/">RamadhanMkoma</a>)
 * @version 1.0
 * @since 07/2023
 */
@RequiredArgsConstructor
@Service
@Transactional
@Slf4j //print int the console
public class StudentServiceImpl implements StudentService {

    @Autowired
    private final StudentRepo studentRepo;

    @Override
    public Student create(Student student) {
        log.info("Creating new Student: {}", student.getRegNo());
        return studentRepo.saveAndFlush(student);
    }

    @Override
    public Collection<Student> list(int limit) {
        log.info("Fetching All Students...");
        return studentRepo.findAll(of(0, limit)).toList();
    }

    @Override
    public Student get(Long id) {
        log.info("Fetching Student By ID...");
        Optional<Student> student = studentRepo.findById(id);
        return student.orElse(null);
    }

    @Override
    public Student update(Student student) {
        log.info("Update student: {} {}", student.getFname(), student.getLname());
        return studentRepo.saveAndFlush(student);
    }

    @Override
    public Boolean delete(Long id) {
        log.info("Deleting Student: {}", id);
        Optional<Student> student = studentRepo.findById(id);
        if (student.isPresent()) {
            studentRepo.deleteById(id);
            return TRUE;
        }
        return false;
    }

    @Override
    public Student markAttendance(String regNo) {
        log.info("Marking Attendance STATUS: {}", regNo);
        Student student = studentRepo.findStudentByRegNo(regNo);
        student.setStatus(ATTENDED);
        return studentRepo.saveAndFlush(student);

    }

    @Override
    public Student email(String email) {
        log.info("Fetching By Email: {}", email);
        Optional<Student> student = studentRepo.findStudentByEmail(email);
        return student.orElseThrow(() -> new EmailNotFoundException("User with Email " + email + " was not found"));
    }
}

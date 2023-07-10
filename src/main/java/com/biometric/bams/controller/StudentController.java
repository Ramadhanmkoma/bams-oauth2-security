package com.biometric.bams.controller;

import com.biometric.bams.enumeration.Status;
import com.biometric.bams.model.Response;
import com.biometric.bams.model.Student;
import com.biometric.bams.repository.StudentRepo;
import com.biometric.bams.service.StudentService;
import com.biometric.bams.service.implementation.StudentServiceImpl;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.time.LocalDate;
import java.util.Collection;
import java.util.List;
import java.util.Map;

import static com.biometric.bams.enumeration.Status.ATTENDED;
import static java.time.LocalDate.now;
import static java.util.Map.of;
import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.OK;

/**
 * @author Ramadhan Mohammed Mkoma (<a href="http://www.ramadhanmkoma.me/">RamadhanMkoma</a>)
 * @version 1.0
 * @since 07/2023
 */
@CrossOrigin("*")
@RestController  //Respond to payloads incoming and outgoing as JSON REST endpoints
@RequestMapping(path = "/api/students")     //Tells the router what mapping url will look like.
@RequiredArgsConstructor
public class StudentController {
    private final StudentServiceImpl studentService;

    @GetMapping("/list")
    public ResponseEntity<Response> getStudents() {
        Collection<Student> student = studentService.list(1000);
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(now())
                        .data(of("students", student))
                        .message("Students Retrieved")
                        .status(OK)
                        .statusCode(OK.value())
                        .build()
        );
    }

    @GetMapping("status/{regNo}")
    public ResponseEntity<Response> markStudentAttendance(@PathVariable("regNo") String regNo) throws IOException {
        Student student = studentService.markAttendance(regNo);
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(now())
                        .data(of("student", student))
                        .message(student.getStatus() == ATTENDED ? "attended" : "missed")
                        .status(OK)
                        .statusCode(OK.value())
                        .build()
        );
    }

    @PostMapping
    public ResponseEntity<Response> addStudent(@RequestBody @Valid Student student) {
        Student student1 = studentService.create(student);
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(now())
                        .data(of("student", student1))
                        .message("Student Added")
                        .status(CREATED)
                        .statusCode(CREATED.value())
                        .build()
        );
    }

    @GetMapping("/{id}")
    public ResponseEntity<Response> getOneStudent(@PathVariable Long id) {
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(now())
                        .data(of("students", studentService.get(id)))
                        .message("Student Retrieved")
                        .status(OK)
                        .statusCode(OK.value())
                        .build()
        );
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Response> deleteStudent(@PathVariable Long id) {
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(now())
                        .data(of("deleted", studentService.delete(id)))
                        .message("Student Deleted")
                        .status(OK)
                        .statusCode(OK.value())
                        .build()
        );
    }
}

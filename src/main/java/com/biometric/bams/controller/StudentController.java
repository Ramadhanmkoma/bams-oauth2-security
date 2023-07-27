package com.biometric.bams.controller;

import com.biometric.bams.model.Student;
import com.biometric.bams.model.User;
import com.biometric.bams.repository.StudentRepo;
import com.biometric.bams.response.Response;
import com.biometric.bams.service.StudentService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.Collection;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/students")
@RequiredArgsConstructor
@CrossOrigin("*")
@Slf4j
public class StudentController {
    private final StudentService studentService;
    private final StudentRepo studentRepo;

    @GetMapping
    public ResponseEntity<Response> getList() throws Exception {
        log.info("Selecting process");
        Collection<User> students = studentService.list();
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(LocalDateTime.now().toString())
                        .data(Map.of("students", students))
                        .message("Student successfully retrieved")
                        .status(HttpStatus.OK)
                        .statusCode(HttpStatus.OK.value())
                        .build()
        );
    }

    @GetMapping("/{id}")
    public ResponseEntity<Response> getOne(@PathVariable("id") Long id) {
        Optional<Student> student = studentService.getOne(id);
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(LocalDateTime.now().toString())
                        .data(Map.of("student", student))
                        .status(HttpStatus.OK)
                        .statusCode(HttpStatus.OK.value())
                        .message("Student retrieved")
                        .build()
        );
    }

    @GetMapping("/username/{username}")
    public ResponseEntity<Response> getUsername(@PathVariable("username") String uname) {
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(LocalDateTime.now().toString())
                        .data(Map.of("student", studentService.getUsername(uname)))
                        .message("Student Found Success!")
                        .status(HttpStatus.FOUND)
                        .statusCode(HttpStatus.FOUND.value())
                        .build()
        );
    }

    @GetMapping("/reg/{reg_no}")
    public ResponseEntity<Response> getByRegNo(@PathVariable("reg_no") String regNo) {
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(LocalDateTime.now().toString())
                        .data(Map.of("student", studentService.getRegNo(regNo)))
                        .message("Student Found Success!")
                        .status(HttpStatus.FOUND)
                        .statusCode(HttpStatus.FOUND.value())
                        .build()
        );
    }

    @GetMapping("/email/{email}")
    public ResponseEntity<Response> getByEmail(@PathVariable("email") String email) {
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(LocalDateTime.now().toString())
                        .data(Map.of("student", studentService.getEmail(email)))
                        .message("Student Found Success!")
                        .status(HttpStatus.FOUND)
                        .statusCode(HttpStatus.FOUND.value())
                        .build()
        );
    }

    @PostMapping("/create")
    public ResponseEntity<Response> saveStudent(@RequestBody @Valid Student user) {
        Student student = studentService.create(user);
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(LocalDateTime.now().toString())
                        .data(Map.of("student", student))
                        .message("Student Created")
                        .status(HttpStatus.CREATED)
                        .statusCode(HttpStatus.CREATED.value())
                        .build()
        );
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Response> update(@PathVariable("id") Long id, @RequestBody @Valid Student student) {
        Student student1 = studentService.update(id, student);
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(LocalDateTime.now().toString())
                        .data(Map.of("student", student1))
                        .message("Student updated successfully")
                        .status(HttpStatus.OK)
                        .statusCode(HttpStatus.OK.value())
                        .build()
        );
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") Long id) {
        if (studentRepo.findById(id).isPresent()) {
            studentService.delete(id);
            return ResponseEntity.ok(
                    Response.builder()
                            .developerMessage("OK { 200 } returned")
                            .message("Success! Student with id " + id + " was deleted successfully")
                            .status(HttpStatus.OK)
                            .statusCode(HttpStatus.OK.value())
                            .timeStamp(LocalDateTime.now().toString())
                            .build()
            );
        } else {
            return ResponseEntity.ok(
                    Response.builder()
                            .developerMessage("Confirm the student id")
                            .message("OOPS! Student with id " + id + " was not found")
                            .reason("Incorrect Id assigned or doesn't exist")
                            .status(HttpStatus.NOT_FOUND)
                            .statusCode(HttpStatus.NOT_FOUND.value())
                            .timeStamp(LocalDateTime.now().toString())
                            .build()
            );
        }
    }


}

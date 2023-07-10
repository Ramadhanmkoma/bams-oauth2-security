package com.biometric.bams.controller;

import com.biometric.bams.model.Lecturer;
import com.biometric.bams.model.Response;
import com.biometric.bams.service.LecturerService;
import com.biometric.bams.service.implementation.LecturerServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.Collection;
import java.util.List;
import java.util.Map;

@CrossOrigin("*")
@RestController
@RequestMapping("api/lecturers")
@RequiredArgsConstructor
public class LecturerController {

    @Autowired
    private LecturerServiceImpl lecturerService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Collection<Lecturer>> getLecturers() {
        Collection<Lecturer> lecturer = lecturerService.list();
        return new ResponseEntity<>(lecturer, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Response> getLecturerById(@PathVariable Long id) {
        Lecturer lecturer = lecturerService.get(id);
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(LocalDate.now())
                        .data(Map.of("lecturer", lecturer))
                        .message("Lecturer Retrieved")
                        .status(HttpStatus.OK)
                        .statusCode(HttpStatus.OK.value()).build()
        );
    }

    @PostMapping
    public ResponseEntity<Lecturer> addNewLecturer(@RequestBody final Lecturer lecturer) {
        Lecturer lecturer1 = lecturerService.create(lecturer);
        return new ResponseEntity<>(lecturer1, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Lecturer> updateLecturer(@PathVariable("id") Long id, Lecturer lecturer) {
        Lecturer lecturer1 = lecturerService.update(id, lecturer);
        return new ResponseEntity<>(lecturer1, HttpStatus.OK);
    }

    @GetMapping(path = "/find/{email}")
    public ResponseEntity<Lecturer> findLecturerByEmail(@PathVariable("email") String email) {
        Lecturer lecturer = lecturerService.getByEmail(email);
        return new ResponseEntity<>(lecturer, HttpStatus.FOUND);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteLecturerById(@PathVariable("id") Long id) {
        lecturerService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}

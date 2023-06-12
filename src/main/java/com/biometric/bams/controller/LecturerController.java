package com.biometric.bams.controller;

import com.biometric.bams.model.Lecturer;
import com.biometric.bams.repository.LecturerRepo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/v1/lecturers")
public class LecturerController {

    @Autowired
    private LecturerRepo lecturerRepo;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Lecturer> getLecturers() {
        return lecturerRepo.findAll();
    }

    @GetMapping
    @RequestMapping("{id}")
    @ResponseStatus(HttpStatus.FOUND)
    public Lecturer getLecturerById(@PathVariable Long id) {
        return lecturerRepo.getOne(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Lecturer addNewLecturer(@RequestBody final Lecturer lecturer) {
        return lecturerRepo.saveAndFlush(lecturer);
    }

    @DeleteMapping
    @RequestMapping(value = "{id}", method = RequestMethod.DELETE)
    public void deleteLecturer(@PathVariable Long id) {
        // Also need to check for children records before deleting.
        lecturerRepo.deleteById(id);
    }

    @PutMapping
    @RequestMapping(value = "{id}", method = RequestMethod.PUT)
    public Lecturer updateLecturer(@PathVariable Long id, @RequestBody Lecturer lecturer) {
        Lecturer existingLecturer = lecturerRepo.getOne(id);
        BeanUtils.copyProperties(lecturer, existingLecturer, "lecturer_id");
        return lecturerRepo.saveAndFlush(existingLecturer);
    }
}

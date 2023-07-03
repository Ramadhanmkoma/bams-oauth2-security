package com.biometric.bams.controller;

import com.biometric.bams.model.Student;
import com.biometric.bams.repository.StudentRepo;
import com.biometric.bams.service.StudentService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController  //Respond to payloads incoming and outgoing as JSON REST endpoints
@RequestMapping(path = "/api/v1/students")     //Tells the router what mapping url will look like.
public class StudentController {
    @Autowired
    private StudentRepo studentRepo;

    private final StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Student> getStudents() { return studentService.getStudents(); }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Student addStudent(@RequestBody Student student) {
        return  studentRepo.saveAndFlush(student);
    }

    @PutMapping
    @ResponseStatus(HttpStatus.ACCEPTED)
    @RequestMapping(value = "{id}", method = RequestMethod.PUT)
    public Student updateStudent(@PathVariable Long id, @RequestBody Student student) {
        Student existingStudent = studentRepo.getOne(id);
        BeanUtils.copyProperties(student, existingStudent, "stud_id");
        return studentRepo.saveAndFlush(existingStudent);
    }
}

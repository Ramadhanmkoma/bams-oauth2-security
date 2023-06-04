package com.biometric.bams.controller;

import com.biometric.bams.repository.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController  //Respond to payloads incoming and outgoing as JSON REST endpoints
@RequestMapping("/api/v1/students")     //Tells the router what mapping url will look like.
public class StudentController {

    //Inject or autowire the students repository
    @Autowired
    private StudentRepo studentRepo;
}

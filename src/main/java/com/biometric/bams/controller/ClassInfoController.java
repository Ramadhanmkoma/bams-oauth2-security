package com.biometric.bams.controller;

import com.biometric.bams.model.ClassInfo;
import com.biometric.bams.model.Lecturer;
import com.biometric.bams.repository.ClassInfoRepo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/v1/classinfo")
public class ClassInfoController {

    @Autowired
    private ClassInfoRepo classInfoRepo;

    @GetMapping     //This annotation GetMapping tells which HTTP verb to use, which will be a GET verb to call this endpoints.
    public List<ClassInfo> getClassInfos() {
        return classInfoRepo.findAll();
    }

    @GetMapping
    @RequestMapping("{id}")
    public ClassInfo getClassInfoById(@PathVariable Integer id) {
        return classInfoRepo.getOne(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)    //maps to 201 in the HTTP world.
    public ClassInfo addClassInfo(@RequestBody final ClassInfo classInfo) {
        return classInfoRepo.saveAndFlush(classInfo);
    }

    @DeleteMapping
    @RequestMapping(value = "{id}", method = RequestMethod.DELETE)
    public void deleteClassInfo(@PathVariable Integer id) {
        classInfoRepo.deleteById(id);
    }

    @PutMapping
    @RequestMapping(value = "{id}", method = RequestMethod.PUT)
    public ClassInfo updateClassInfo(@PathVariable Integer id, @RequestBody ClassInfo classInfo) {
        // we need to get the existing classInfo
        ClassInfo existingClassInfo = classInfoRepo.getOne(id);
        BeanUtils.copyProperties(classInfo, existingClassInfo, "class_id");
        return classInfoRepo.saveAndFlush(existingClassInfo);
    }
}

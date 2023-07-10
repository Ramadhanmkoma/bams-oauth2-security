package com.biometric.bams.service;

import com.biometric.bams.model.Lecturer;
import java.util.Collection;

public interface LecturerService {
    Lecturer create(Lecturer lecturer);
    Collection<Lecturer> list();
    Lecturer get(Long id);
    Lecturer update(Long id, Lecturer lecturer);
    void delete(Long id);
}

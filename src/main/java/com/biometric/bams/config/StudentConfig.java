package com.biometric.bams.config;

import com.biometric.bams.model.Student;
import com.biometric.bams.repository.StudentRepo;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@Configuration
public class StudentConfig {

    @Bean
    CommandLineRunner commandLineRunner(StudentRepo repo) {
        return args -> {
            Student ally = new Student(
                    "BSWS/15/20/005/TZ",
                    "Ally",
                    "Ibrahim",
                    "255766570255",
                    "",
                    LocalDate.of(1999, Month.JULY, 7),
                    'M'
                    );

            Student abdully = new Student(
                    "BSWS/15/20/005/TZ",
                    "Abdully-nasri",
                    "Mohammed",
                    "255766570255",
                    "",
                    LocalDate.of(2004, Month.OCTOBER, 7),
                    'M'
            );

            repo.saveAll(
                    List.of(ally, abdully)
            );
        };
    }
}

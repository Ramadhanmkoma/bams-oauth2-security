package com.biometric.bams;

import com.biometric.bams.model.Student;
import com.biometric.bams.repository.StudentRepo;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDate;

@SpringBootApplication
public class BamsApplication {

	public static void main(String[] args) {
		SpringApplication.run(BamsApplication.class, args);
	}

}

package com.biometric.bams.model;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * @author: Ramadhan Mohammed
 * @website: <a href="http://ramadhanmkoma.me">Ramadhan</a>
 * @createdDate: Thursday, 20 July 2023
 */
@Data
@Entity
@Table(name = "bams_hrs")
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class HR extends User{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    @NotEmpty(message = "employee id cannot be empty")
    private String empId;
}

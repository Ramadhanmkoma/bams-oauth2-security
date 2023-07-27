package com.biometric.bams.repository;

import com.biometric.bams.model.Admin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author: Ramadhan Mohammed
 * @website: <a href="http://ramadhanmkoma.me">Ramadhan</a>
 * @createdDate: Thursday, 20 July 2023
 */
@Repository
public interface AdminRepository extends JpaRepository<Admin, Long> {
}

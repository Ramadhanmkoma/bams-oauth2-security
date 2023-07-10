package com.biometric.bams.repository;

import com.biometric.bams.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * @author Ramadhan Mohammed Mkoma (<a href="http://www.ramadhanmkoma.me/">RamadhanMkoma</a>)
 * @version 1.0
 * @since 07/2023
 */
@Repository
public interface StudentRepo extends JpaRepository<Student, Long> {
    /**
     * Find User By Email Address -> Construct the query based
     * SELECT * FROM student WHERE email = what we pass
     */
    Optional<Student> findStudentByEmail(String email);

    /**
     * Find User By Registration number -> Construct the query based
     * SELECT * FROM student WHERE RegNumber = what we pass
     */
//    @Query("select st from Student st where st.regNo=?1")
    Student findStudentByRegNo(String regNo);

}

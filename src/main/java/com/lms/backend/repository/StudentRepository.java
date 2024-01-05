package com.lms.backend.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.lms.backend.entity.Student;

public interface StudentRepository extends JpaRepository<Student, Long> {
    
}

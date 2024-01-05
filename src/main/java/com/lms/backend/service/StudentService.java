package com.lms.backend.service;
import java.util.List;
import org.springframework.stereotype.Service;
import com.lms.backend.dto.StudentDTO;

@Service
public interface StudentService {
    StudentDTO createStudent(StudentDTO studentDTO);

    StudentDTO getStudentById(Long studentId);

    List<StudentDTO> getAllStudents();

    StudentDTO updateStudent(Long studentId, StudentDTO updatedStudent);

    void deleteStudent(Long studentId);
}

package com.lms.backend.mapper;

import com.lms.backend.dto.StudentDTO;
import com.lms.backend.entity.Student;

public class StudentMapper {

    public static StudentDTO mapToStudentDTO(Student student){
        return new StudentDTO(
                student.getId(),
                student.getFirstName(),
                student.getLastName(),
                student.getEmail()
        );
    }

    public static Student mapToStudent(StudentDTO studentDTO){
        return new Student(
                studentDTO.getId(),
                studentDTO.getFirstName(),
                studentDTO.getLastName(),
                studentDTO.getEmail()
        );
    }
    
}

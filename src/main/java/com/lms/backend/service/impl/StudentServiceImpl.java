package com.lms.backend.service.impl;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lms.backend.dto.StudentDTO;
import com.lms.backend.entity.Student;
import com.lms.backend.exception.ResourceNotFoundException;
import com.lms.backend.mapper.StudentMapper;
import com.lms.backend.repository.StudentRepository;
import com.lms.backend.service.StudentService;

@Service
public class StudentServiceImpl implements StudentService{
    @Autowired
    private StudentRepository studentRepository;

    @Override
    public StudentDTO createStudent(StudentDTO studentDTO) {
        Student student = StudentMapper.mapToStudent(studentDTO);
        Student savedStudent = studentRepository.save(student);
        return StudentMapper.mapToStudentDTO(savedStudent);
    }

    @Override
    public StudentDTO getStudentById(Long studentId) {
        Student student = studentRepository.findById(studentId)
        .orElseThrow(() -> new ResourceNotFoundException("There is no student with the id " + studentId));
        return StudentMapper.mapToStudentDTO(student);
    }

    @Override
    public List<StudentDTO> getAllStudents() {
        List<Student>students=studentRepository.findAll();
        return students.stream().map((student) ->StudentMapper.mapToStudentDTO(student))
        .collect(Collectors.toList());
    }

    @Override
    public StudentDTO updateStudent(Long studentId, StudentDTO updatedStudent) {
        Student student = studentRepository.findById(studentId).orElseThrow(
            () -> new ResourceNotFoundException("There is no student with the id " + studentId)
        );
        student.setFirstName(updatedStudent.getFirstName());
        student.setLastName(updatedStudent.getLastName());
        student.setEmail(updatedStudent.getEmail());
        Student updatedStudentObj = studentRepository.save(student);
        return StudentMapper.mapToStudentDTO(updatedStudentObj);
    }

    @Override
    public void deleteStudent(Long studentId) {
        Student student = studentRepository.findById(studentId).orElseThrow(
            () -> new ResourceNotFoundException("There is no student with the id " + studentId)
        );
        studentRepository.deleteById(studentId);
    }   
}


package com.lms.backend.controller;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.lms.backend.dto.StudentDTO;
import com.lms.backend.service.StudentService;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping(value = "/api/students")
@AllArgsConstructor
@Controller
public class StudentController {

    private StudentService studentService;

    @PostMapping
    public ResponseEntity <StudentDTO> createStudent(@RequestBody StudentDTO studentDTO){
    StudentDTO savedStudent = studentService.createStudent(studentDTO);
    return new ResponseEntity<>(savedStudent, HttpStatus.CREATED);
    }

    @GetMapping("{id}")
    public ResponseEntity <StudentDTO> getStudentById(@PathVariable ("id")Long studentId){
    StudentDTO studentDTO=studentService.getStudentById(studentId);
    return ResponseEntity.ok(studentDTO);
    }

    @PutMapping("{id}")
    public ResponseEntity<StudentDTO> updateStudent(@PathVariable ("id")Long studentId, @RequestBody StudentDTO updatedStudent){
    StudentDTO studentDTO= studentService.updateStudent(studentId, updatedStudent);
    return ResponseEntity.ok(studentDTO);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteStudent(@PathVariable("id")Long studentId){
    studentService.deleteStudent(studentId);
    return ResponseEntity.ok("Employee deleted successfully");
    }  
}
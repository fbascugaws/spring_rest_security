package com.spring.spring_rest_security.service;

import com.spring.spring_rest_security.dto.StudentDto;
import java.util.List;

/**
 * StudentService
 * Service interface defining business operations for managing student records.
 * 
 * @author Felisa Bascug
 */
public interface StudentService {

    StudentDto createStudent(StudentDto studentDto);
    StudentDto getStudentById(Long id);
    List<StudentDto> getAllStudents();
    StudentDto updateStudent(Long id, StudentDto studentDto);
    StudentDto patchStudent(Long id, StudentDto studentDto);
    void deleteStudentById(Long id);

}

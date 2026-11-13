package com.spring.spring_rest_security.controller;

import com.spring.spring_rest_security.dto.StudentDto;
import com.spring.spring_rest_security.service.StudentService;
import jakarta.validation.Valid;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * StudentRestController
 * <p>
 * REST controller for managing student resources.
 * Exposes endpoints under {@code /api/students} for creating, retrieving,
 * updating, and deleting student records.
 * </p>
 * 
 * @author Felisa Bascug
 */
@RestController 
@RequestMapping ("/api/students")
public class StudentRestController {

    private StudentService studentService;

    public StudentRestController(StudentService studentService) {
        this.studentService = studentService;
    }

    /**
     * Creates a new student record from the provided request payload.
     *
     * @param studentDto JSON payload converted and validated into a 
     *                      {@link StudentDto}
     * @return a {@link ResponseEntity} containing the saved {@link StudentDto}
     *           and HTTP 201 (Created)
     */
    @PostMapping
    public ResponseEntity<StudentDto> createStudents(
            @Valid @RequestBody StudentDto studentDto) {
        
        StudentDto saved = studentService.createStudent(studentDto);
        
        return new ResponseEntity<>(saved, HttpStatus.CREATED);
    }
    
    /**
     * Retrieves a single student record by its unique identifier.
     *
     * @param id the unique identifier of the student
     * @return a {@link ResponseEntity} containing the matching 
     *          {@link StudentDto} and HTTP 200 (OK)
     */
    @GetMapping ("{id}")
    public ResponseEntity<StudentDto> getStudentById(@PathVariable Long id) {
        
        StudentDto studentDto = studentService.getStudentById(id);

        return ResponseEntity.ok(studentDto);
    }

    /**
     * Retrieves a list of all existing student records.
     *
     * @return a {@link ResponseEntity} containing a {@link List} of 
     *          {@link StudentDto} objects and HTTP 200 (OK)
     */
    @GetMapping 
    public ResponseEntity<List<StudentDto>> getAllStudents() {
        
        List<StudentDto> students = studentService.getAllStudents();

        return ResponseEntity.ok(students);
    }

    /**
     * Fully updates an existing student record with the provided data.
     *
     * @param id the unique identifier of the student to update
     * @param theStudentDto the validated {@link StudentDto} containing updated
     *                      student fields
     * @return a {@link ResponseEntity} containing the updated 
     *          {@link StudentDto} and HTTP 200 (OK)
     */
    @PutMapping("{id}")
    public ResponseEntity<StudentDto> updateStudent(@PathVariable Long id, 
            @Valid @RequestBody StudentDto theStudentDto) {
        
        StudentDto studentDto = studentService.updateStudent
            (id, theStudentDto);
        
        return ResponseEntity.ok(studentDto);
    }

    /**
     * Partially updates an existing student record with the provided non-null 
     * fields.
     *
     * @param id the unique identifier of the student to patch
     * @param theStudentDto the validated {@link StudentDto} containing the 
     *                      fields to modify
     * @return a {@link ResponseEntity} containing the patched 
     *          {@link StudentDto} and HTTP 200 (OK)
     */
    @PatchMapping ("{id}")
    public ResponseEntity<StudentDto> patchStudent(@PathVariable Long id, 
            @Valid @RequestBody StudentDto theStudentDto) {
        
        StudentDto studentDto = studentService.patchStudent(id, theStudentDto);
        
        return ResponseEntity.ok(studentDto);
    }

    /**
     * Deletes an existing student record by its unique identifier.
     *
     * @param id the unique identifier of the student to delete
     * @return a {@link ResponseEntity} containing a confirmation message and 
     *          HTTP 200 (OK)
     */
    @DeleteMapping ("{id}")
    public ResponseEntity<String> deleteStudentById(@PathVariable Long id) {
        
        studentService.deleteStudentById(id);
        
        return ResponseEntity.ok("Student deleted successfully!");
    }

}

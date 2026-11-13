package com.spring.spring_rest_security.service;

import com.spring.spring_rest_security.dto.StudentDto;
import com.spring.spring_rest_security.entity.Student;
import com.spring.spring_rest_security.exception.StudentNotFoundException;
import com.spring.spring_rest_security.mapper.StudentMapper;
import com.spring.spring_rest_security.repository.StudentRepository;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.stereotype.Service;

/**
 * StudentServiceImplement
 * <p>
 * Implementation of the {@link StudentService} interface.
 * Handles business logic, DTO-to-entity mapping, and persistence operations
 * for student records via {@link StudentRepository}.
 * </p>
 * 
 * @author Felisa Bascug
 */
@Service 
public class StudentServiceImplement implements StudentService {

    private StudentRepository studentRepo;    

    public StudentServiceImplement(StudentRepository studentRepo) {
        this.studentRepo = studentRepo;
    }

    /**
     * Persists a new student record in the database.
     *
     * @param studentDto the {@link StudentDto} containing the details of the 
     *                      student to create
     * @return the saved {@link StudentDto} with its generated identifier
     */
    @Override
    public StudentDto createStudent(StudentDto studentDto) {
        Student student = StudentMapper.mapToStudent(studentDto);
        Student saved = studentRepo.save(student);
        
        return StudentMapper.mapToStudentDto(saved);
    }

    /**
     * Retrieves a single student record by its unique identifier.
     *
     * @param id the unique identifier of the student to retrieve
     * @return the matching {@link StudentDto}
     * @throws StudentNotFoundException if no student exists with the given ID
     */
    @Override
    public StudentDto getStudentById(Long id) {
        
        Student student = studentRepo.findById(id)
            .orElseThrow(() -> new StudentNotFoundException(
                getStudentNotFoundMessage(id)));
        
        return StudentMapper.mapToStudentDto(student);
    }

    /**
     * Retrieves all student records from the database.
     *
     * @return a {@link List} of {@link StudentDto} objects representing all 
     *          students
     */
    @Override
    public List<StudentDto> getAllStudents() {

        List<Student> students = studentRepo.findAll();

        return students.stream().map(
            (student) -> StudentMapper.mapToStudentDto(student))
            .collect(Collectors.toList());
    }

    /**
     * Fully updates an existing student record with new details.
     *
     * @param id         the unique identifier of the student to update
     * @param studentDto the {@link StudentDto} containing the updated student
     *                      fields
     * @return the updated {@link StudentDto}
     * @throws StudentNotFoundException if no student exists with the given ID
     */
    @Override
    public StudentDto updateStudent(Long id, StudentDto studentDto) {
        
        Student student = studentRepo.findById(id)
            .orElseThrow(() -> new StudentNotFoundException(
                getStudentNotFoundMessage(id)));

        student.setFirstName(studentDto.getFirstName());
        student.setLastName(studentDto.getLastName());
        student.setEmail(studentDto.getEmail());

        Student saved = studentRepo.save(student);
        return StudentMapper.mapToStudentDto(saved);
    }

    /**
     * Partially updates an existing student record using only non-null fields
     * from the provided DTO.
     *
     * @param id         the unique identifier of the student to patch
     * @param studentDto the {@link StudentDto} containing the fields to update
     * @return the patched {@link StudentDto}
     * @throws StudentNotFoundException if no student exists with the given ID
     */
    @Override
    public StudentDto patchStudent(Long id, StudentDto studentDto) {
        
        Student student = studentRepo.findById(id)
            .orElseThrow(() -> new StudentNotFoundException(
                getStudentNotFoundMessage(id)));

        if (studentDto.getFirstName() != null) {
            student.setFirstName(studentDto.getFirstName());
        }
        if (studentDto.getLastName() != null) {
            student.setLastName(studentDto.getLastName());
        }
        if (studentDto.getEmail() != null) {
            student.setEmail(studentDto.getEmail());
        }

        Student saved = studentRepo.save(student);
        return StudentMapper.mapToStudentDto(saved);
    }

    /**
     * Deletes an existing student record by its unique identifier.
     *
     * @param id the unique identifier of the student to delete
     * @throws StudentNotFoundException if no student exists with the given ID
     */
    @Override
    public void deleteStudentById(Long id) {

        studentRepo.findById(id)
            .orElseThrow(() -> new StudentNotFoundException(
                getStudentNotFoundMessage(id)));

        studentRepo.deleteById(id);
    }

    /**
     * Helper method to format the error message when a requested student
     * cannot be found in the database.
     *
     * @param id the student ID that was not found
     * @return a formatted error message string 
     *          (e.g., {@code "Student id {id} not found!"})
     */
    private String getStudentNotFoundMessage(Long id) {
        return "Student id " + id + " not found!";
    }

}

package com.spring.spring_rest_security.mapper;

import com.spring.spring_rest_security.dto.StudentDto;
import com.spring.spring_rest_security.entity.Student;

/**
 * StudentMapper
 * <p>
 * Utility class responsible for mapping between {@link Student} JPA entities
 * and {@link StudentDto} data transfer objects.
 * </p>
 * 
 * @author Felisa Bascug
 */
public class StudentMapper {

    /**
     * Converts a {@link Student} entity into a {@link StudentDto}.
     *
     * @param student the {@link Student} entity to convert
     * @return the mapped {@link StudentDto} containing the student's details
     */
    public static StudentDto mapToStudentDto(Student student) {
        return new StudentDto(student.getId(), student.getFirstName(), 
                            student.getLastName(), student.getEmail());
    }

    /**
     * Converts a {@link StudentDto} into a {@link Student} entity.
     *
     * @param studentDto the {@link StudentDto} to convert
     * @return the mapped {@link Student} entity containing the DTO's details
     */
    public static Student mapToStudent(StudentDto studentDto) {
        return new Student(studentDto.getId(), studentDto.getFirstName(), 
                        studentDto.getLastName(), studentDto.getEmail());
    }

}

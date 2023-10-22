package se331.rest.lab.service;

import org.springframework.data.domain.Page;

import se331.rest.lab.entity.Student;

public class StudentService {
    Page<Student> getStudents(Integer pageSize, Integer page);

    Student getStudent(Long id);

    Student save(Student student);

}

package se331.rest.lab.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import se331.rest.lab.entity.Student;

public interface StudentService {
    Page<Student> getStudents(Integer pageSize, Integer page);

    Student getStudentById(Long id);

    Page<Student> getStudent(String name, Pageable pageable);

    Student save(Student student);

}

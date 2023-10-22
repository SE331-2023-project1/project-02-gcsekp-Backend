package se331.rest.lab.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import se331.rest.lab.entity.Student;

public interface StudentDao {
    Integer getStudentSize();

    Page<Student> getStudents(Integer pageSize, Integer page);

    Student getStudentById(Long id);

    Student save(Student student);

    Page<Student> getStudent(String name, Pageable page);

}

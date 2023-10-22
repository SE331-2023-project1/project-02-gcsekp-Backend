package se331.rest.lab.dao;

import org.springframework.data.domain.Page;

import se331.rest.lab.entity.Student;

public class StudentDao {
    Integer getStudentSize();

    Page<Student> getEStudents(Integer pageSize, Integer page);

    Student getStudent(Long id);

    Student save(Student student);

}

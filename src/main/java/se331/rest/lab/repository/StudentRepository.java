package se331.rest.lab.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import se331.rest.lab.entity.Student;

public interface StudentRepository extends JpaRepository<Student, Long> {
    List<Student> findAll();

    Page<Student> findByNameContainingIgnoreCaseOrSurnameContainingIgnoreCaseOrStudentIDOrAdvisor_NameContainingIgnoreCase(
            String name, String surName, String studentID, String advisorName, Pageable PageRequest);

}

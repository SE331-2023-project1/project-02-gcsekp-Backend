package se331.rest.lab.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import se331.rest.lab.entity.Student;

public interface StudentRepository extends JpaRepository<Student, Long> {

}

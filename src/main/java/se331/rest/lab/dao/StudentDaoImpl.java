package se331.rest.lab.dao;

import org.springframework.context.annotation.Profile;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Repository;

import lombok.RequiredArgsConstructor;
import se331.rest.lab.entity.Student;
import se331.rest.lab.repository.StudentRepository;

@Repository
@RequiredArgsConstructor
@Profile("db")
public class StudentDaoImpl {
    final StudentRepository studentRepository;

    @Override
    public Integer getStudentSize() {
        return Math.toIntExact(studentRepository.count());
    }

    @Override
    public Page<Student> getEStudents(Integer pageSize, Integer page) {
        long totalEvents = studentRepository.count();
        pageSize = pageSize == null ? (int) totalEvents : pageSize;
        page = page == null ? 0 : page - 1;
        return studentRepository.findAll(PageRequest.of(page, pageSize));
    }

    @Override
    public Student getStudent(Long id) {
        return studentRepository.findById(id).orElse(null);
    }

    @Override
    public Student save(Student student) {
        return studentRepository.save(student);
    }

}

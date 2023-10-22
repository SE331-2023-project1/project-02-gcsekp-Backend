package se331.rest.lab.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import se331.rest.lab.dao.StudentDao;
import se331.rest.lab.entity.Student;

@Service
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService {
    final StudentDao studentDao;

    @Override
    public Page<Student> getStudents(Integer pageSize, Integer page) {
        return studentDao.getStudents(pageSize, page);
    }

    @Override
    public Student getStudentById(Long id) {
        return studentDao.getStudentById(id);
    }

    @Override
    public Page<Student> getStudent(String name, Pageable pageable) {
        return studentDao.getStudent(name, pageable);
    }

    @Override
    public Student save(Student student) {
        return studentDao.save(student);
    }

}

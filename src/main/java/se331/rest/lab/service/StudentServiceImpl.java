package se331.rest.lab.service;

import org.springframework.data.domain.Page;
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
        return studentDao.getEStudents(pageSize, page);
    }

    @Override
    public Student getStudent(Long id) {
        return studentDao.getStudent(id);
    }

    @Override
    public Student save(Student student) {
        return studentDao.save(student);
    }

}

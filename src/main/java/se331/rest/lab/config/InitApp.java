package se331.rest.lab.config;

import java.util.List;

import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import lombok.RequiredArgsConstructor;
import se331.rest.lab.entity.Advisor;
import se331.rest.lab.entity.Student;
import se331.rest.lab.repository.AdvisorRepository;
import se331.rest.lab.repository.StudentRepository;

@Component
@RequiredArgsConstructor
public class InitApp {
    final AdvisorRepository advisorRepository;
    final StudentRepository studentRepository;

    @Override
    @Transactional
    public void onApplicationEvent(ApplicationReadyEvent applicationReadyEvent) {
        Advisor advisor1, advisor2;
        Student student1, student2, student3, student4;
        student1 = studentRepository.save(Student.builder()
                .studentID("S001")
                .name("John")
                .surname("Doe")
                .department("Computer Science")
                .build());
        student2 = studentRepository.save(Student.builder()
                .studentID("S002")
                .name("Jane")
                .surname("Smith")
                .department("Mathematics")
                .build());
        student3 = studentRepository.save(Student.builder()
                .studentID("S003")
                .name("Alice")
                .surname("Johnson")
                .department("Physics")
                .build());
        student4 = studentRepository.save(Student.builder()
                .studentID("S004")
                .name("Bob")
                .surname("Brown")
                .department("Chemistry")
                .build());
        advisor1 = advisorRepository.save(Advisor
                .builder()
                .name("Somsak")
                .surname("Smith")
                .department("English language teaching")
                .position("Lecturer")
                .build());
        advisor1.getStudentList().addAll(List.of(student1, student2));
        advisor2 = advisorRepository.save(Advisor.builder()
                .name("Ahmed")
                .surname("Khan")
                .department("Business Administration")
                .position("Researcher")
                .build());
        advisor2.getStudentList().addAll(List.of(student3, student4));

        student1.setAdvisor(advisor1);
        student2.setAdvisor(advisor1);
        student3.setAdvisor(advisor2);
        student4.setAdvisor(advisor2);

    }

}

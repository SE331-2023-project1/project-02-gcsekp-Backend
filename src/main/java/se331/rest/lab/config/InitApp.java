package se331.rest.lab.config;

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
        Advisor advisor1, advisor2, advisor3, advisor4, advisor5, advisor6;
        advisor1 = advisorRepository.save(Advisor
                .builder()
                .name("Somsak")
                .surname("Smith")
                .department("English")
                .position("Lecturer")
                .advisorID("A001")
                .build());
        advisor2 = advisorRepository.save(Advisor.builder()
                .name("Ahmed")
                .surname("Khan")
                .department("Business Administration")
                .position("Researcher")
                .advisorID("A002")
                .build());
        advisor3 = advisorRepository.save(Advisor.builder()
                .name("Astor   ")
                .surname("Hawk")
                .department("Mathematics")
                .position("Professor")
                .advisorID("A003")
                .build());

        advisor4 = advisorRepository.save(Advisor.builder()
                .name("Alice")
                .surname("Johnson")
                .department("History")
                .position("Associate Professor")
                .advisorID("A004")
                .build());

        advisor5 = advisorRepository.save(Advisor.builder()
                .name("Kathy")
                .surname("Merton")
                .department("Physics")
                .position("Assistant Professor")
                .advisorID("A005")
                .build());
        advisor6 = advisorRepository.save(Advisor.builder()
                .name("David")
                .surname("Lee")
                .department("Computer Science")
                .position("Professor")
                .advisorID("A006")
                .build());

        Student student;
        student = studentRepository.save(Student.builder()
                .studentID("S001")
                .name("Daisy")
                .surname("Walsh")
                .department("Computer Science")
                .build());
        student.setAdvisor(advisor1);
        advisor1.getStudentList().add(student);

        student = studentRepository.save(Student.builder()
                .studentID("S002")
                .name("Jerry")
                .surname("Perry")
                .department("Mathematics")
                .build());
        student.setAdvisor(advisor1);
        advisor1.getStudentList().add(student);

        student = studentRepository.save(Student.builder()
                .studentID("S003")
                .name("Jerry")
                .surname("Perry")
                .department("Physics")
                .build());
        student.setAdvisor(advisor2);
        advisor2.getStudentList().add(student);

        student = studentRepository.save(Student.builder()
                .studentID("S004")
                .name("Bob")
                .surname("Brown")
                .department("Chemistry")
                .build());
        student.setAdvisor(advisor2);
        advisor2.getStudentList().add(student);

        student = studentRepository.save(Student.builder()
                .studentID("S005")
                .name("Grace")
                .surname("Adams")
                .department("English")
                .build());
        student.setAdvisor(advisor3);
        advisor3.getStudentList().add(student);

        student = studentRepository.save(Student.builder()
                .studentID("S006")
                .name("Henry")
                .surname("Wilson")
                .department("Engineering")
                .build());
        student.setAdvisor(advisor3);
        advisor3.getStudentList().add(student);

        student = studentRepository.save(Student.builder()
                .studentID("S007")
                .name("Isabella")
                .surname("Harris")
                .department("Geology")
                .build());
        student.setAdvisor(advisor4);
        advisor4.getStudentList().add(student);

        student = studentRepository.save(Student.builder()
                .studentID("S008")
                .name("Jane")
                .surname("Lee")
                .department("Psychology")
                .build());
        student.setAdvisor(advisor4);
        advisor4.getStudentList().add(student);

        student = studentRepository.save(Student.builder()
                .studentID("S009")
                .name("Jackson")
                .surname("Parker")
                .department("Computer Science")
                .build());
        student.setAdvisor(advisor5);
        advisor5.getStudentList().add(student);

        student = studentRepository.save(Student.builder()
                .studentID("S010")
                .name("Sandra")
                .surname("Bullock")
                .department("Biology")
                .build());
        student.setAdvisor(advisor5);
        advisor5.getStudentList().add(student);

        student = studentRepository.save(Student.builder()
                .studentID("S011")
                .name("Scooby")
                .surname("Doo")
                .department("Mathematics")
                .build());
        student.setAdvisor(advisor6);
        advisor6.getStudentList().add(student);

        student = studentRepository.save(Student.builder()
                .studentID("S012")
                .name("Jennifer")
                .surname("Kim")
                .department("History")
                .build());
        student.setAdvisor(advisor6);
        advisor6.getStudentList().add(student);

        student = studentRepository.save(Student.builder()
                .studentID("S013")
                .name("Mika")
                .surname("Donald")
                .department("Social")
                .build());
        student.setAdvisor(advisor1);
        advisor1.getStudentList().add(student);

        student = studentRepository.save(Student.builder()
                .studentID("S014")
                .name("Silver")
                .surname("Morgan")
                .department("Geology")
                .build());
        student.setAdvisor(advisor2);
        advisor2.getStudentList().add(student);

        student = studentRepository.save(Student.builder()
                .studentID("S015")
                .name("Casper")
                .surname("Miller")
                .department("Music")
                .build());
        student.setAdvisor(advisor3);
        advisor3.getStudentList().add(student);

        student = studentRepository.save(Student.builder()
                .studentID("S016")
                .name("Sparkle")
                .surname("Evans")
                .department("Biology")
                .build());
        student.setAdvisor(advisor4);
        advisor4.getStudentList().add(student);

        student = studentRepository.save(Student.builder()
                .studentID("S017")
                .name("Rose")
                .surname("Lopez")
                .department("Chemistry")
                .build());
        student.setAdvisor(advisor5);
        advisor5.getStudentList().add(student);

        student = studentRepository.save(Student.builder()
                .studentID("S018")
                .name("Mickey")
                .surname("Mouse")
                .department("Biology")
                .build());
        student.setAdvisor(advisor6);
        advisor6.getStudentList().add(student);

        student = studentRepository.save(Student.builder()
                .studentID("S019")
                .name("Peter")
                .surname("Pan")
                .department("Engineering")
                .build());
        student.setAdvisor(advisor1);
        advisor1.getStudentList().add(student);

        student = studentRepository.save(Student.builder()
                .studentID("S020")
                .name("Ella")
                .surname("Robinson")
                .department("Mathematics")
                .build());
        student.setAdvisor(advisor2);
        advisor2.getStudentList().add(student);

        student = studentRepository.save(Student.builder()
                .studentID("S021")
                .name("Olaf")
                .surname("Leonard")
                .department("Music")
                .build());
        student.setAdvisor(advisor3);
        advisor3.getStudentList().add(student);

        student = studentRepository.save(Student.builder()
                .studentID("S022")
                .name("Tinkle")
                .surname("Bell")
                .department("Physics")
                .build());
        student.setAdvisor(advisor4);
        advisor4.getStudentList().add(student);

        student = studentRepository.save(Student.builder()
                .studentID("S023")
                .name("Tiger")
                .surname("Lily")
                .department("History")
                .build());
        student.setAdvisor(advisor5);
        advisor5.getStudentList().add(student);

        student = studentRepository.save(Student.builder()
                .studentID("S024")
                .name("Buzz")
                .surname("Ligthyear")
                .department("Psychology")
                .build());
        student.setAdvisor(advisor6);
        advisor6.getStudentList().add(student);

    }

}

package se331.rest.lab.controller;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.server.ResponseStatusException;

import lombok.RequiredArgsConstructor;
import se331.rest.lab.entity.Student;
import se331.rest.lab.service.StudentService;
import se331.rest.lab.util.LabMapper;

@Controller
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:8080")
public class StudentController {
    final StudentService studentService;

    @GetMapping("students")
    public ResponseEntity<?> getAdvisorLists(@RequestParam(value = "_limit", required = false) Integer perPage,
            // @RequestParam(value = "_page", required = false) Integer page) {
            // Page<Student> pageOutput = studentService.getStudents(perPage, page);
            // Search function
            @RequestParam(value = "_page", required = false) Integer page,
            @RequestParam(value = "title", required = false) String title) {
        perPage = perPage == null ? 3 : perPage;
        page = page == null ? 1 : page;
        Page<Student> pageOutput;
        if (title == null) {
            pageOutput = studentService.getStudents(perPage, page);
        } else {
            pageOutput = studentService.getStudent(title, PageRequest.of(page - 1, perPage));
        }

        HttpHeaders responseHeaders = new HttpHeaders();
        responseHeaders.set("x-total-count", String.valueOf(pageOutput.getTotalElements()));
        return new ResponseEntity<>(LabMapper.INSTANCE.getStudentDto(pageOutput.getContent()), responseHeaders,
                HttpStatus.OK);
    }

    @GetMapping("students/{id}")
    public ResponseEntity<?> getEvent(@PathVariable("id") Long id) {
        Student output = studentService.getStudentById(id);
        if (output != null) {
            return ResponseEntity.ok(LabMapper.INSTANCE.getStudentDto(output));
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "the given id is not found");
        }
    }

    @PutMapping("/students/{id}")
    public ResponseEntity<?> updateStudent(@PathVariable("id") Long id, @RequestBody Student updateStudent) {
        Student existingStudent = studentService.getStudentById(id);
        if (existingStudent != null) {
            if (updateStudent.getName() != null) {
                existingStudent.setName(updateStudent.getName());
            }
            if (updateStudent.getSurname() != null) {
                existingStudent.setSurname(updateStudent.getSurname());
            }
            if (updateStudent.getImage() != null) {
                existingStudent.setImage(updateStudent.getImage());
            }
            Student output = studentService.save(existingStudent);
            return ResponseEntity.ok(LabMapper.INSTANCE.getStudentDto(output));
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "The given id is not found");
        }
    }

}

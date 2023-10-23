package se331.rest.lab.util;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
// import org.springframework.web.bind.annotation.Mapping;

import se331.rest.lab.dto.AdvisorAuthDTO;
import se331.rest.lab.dto.AdvisorDTO;
import se331.rest.lab.dto.OwnStudentDTO;
import se331.rest.lab.dto.OwnsAdvisorDTO;
import se331.rest.lab.dto.StudentAuthDTO;
import se331.rest.lab.dto.StudentDTO;
import se331.rest.lab.entity.Advisor;
import se331.rest.lab.entity.Student;

@Mapper
public interface LabMapper {
    LabMapper INSTANCE = Mappers.getMapper(LabMapper.class);

    StudentDTO getStudentDto(Student student);

    List<StudentDTO> getStudentDto(List<Student> students);

    AdvisorDTO getAdvisorDto(Advisor advisor);

    List<AdvisorDTO> getAdvisorDto(List<Advisor> advisors);

    OwnsAdvisorDTO getAdvisorForStudent(Advisor advisor);

    OwnStudentDTO getStudentForAdvisor(Student student);

    @Mapping(target = "roles", source = "user.roles")
    AdvisorAuthDTO getAdvisorAuthDTO(Advisor advisor);

    @Mapping(target = "roles", source = "user.roles")
    StudentAuthDTO getStudentAuthDTO(Student student);
}

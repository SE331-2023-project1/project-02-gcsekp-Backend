package se331.rest.lab.util;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import se331.rest.lab.dto.AdvisorDTO;
import se331.rest.lab.dto.StudentDTO;
import se331.rest.lab.entity.Advisor;
import se331.rest.lab.entity.Student;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-10-22T17:26:52+0700",
    comments = "version: 1.5.5.Final, compiler: Eclipse JDT (IDE) 3.35.0.v20230814-2020, environment: Java 17.0.4.1 (Amazon.com Inc.)"
)
public class LabMapperImpl implements LabMapper {

    @Override
    public StudentDTO getStudentDto(Student student) {
        if ( student == null ) {
            return null;
        }

        StudentDTO.StudentDTOBuilder studentDTO = StudentDTO.builder();

        studentDTO.department( student.getDepartment() );
        studentDTO.id( student.getId() );
        studentDTO.image( student.getImage() );
        studentDTO.name( student.getName() );
        studentDTO.surname( student.getSurname() );

        return studentDTO.build();
    }

    @Override
    public List<StudentDTO> getStudentDto(List<Student> students) {
        if ( students == null ) {
            return null;
        }

        List<StudentDTO> list = new ArrayList<StudentDTO>( students.size() );
        for ( Student student : students ) {
            list.add( getStudentDto( student ) );
        }

        return list;
    }

    @Override
    public AdvisorDTO getAdvisorDto(Advisor advisor) {
        if ( advisor == null ) {
            return null;
        }

        AdvisorDTO.AdvisorDTOBuilder advisorDTO = AdvisorDTO.builder();

        advisorDTO.advisorID( advisor.getAdvisorID() );
        advisorDTO.department( advisor.getDepartment() );
        advisorDTO.id( advisor.getId() );
        advisorDTO.image( advisor.getImage() );
        advisorDTO.name( advisor.getName() );
        advisorDTO.surname( advisor.getSurname() );

        return advisorDTO.build();
    }

    @Override
    public List<AdvisorDTO> getAdvisorDto(List<Advisor> advisors) {
        if ( advisors == null ) {
            return null;
        }

        List<AdvisorDTO> list = new ArrayList<AdvisorDTO>( advisors.size() );
        for ( Advisor advisor : advisors ) {
            list.add( getAdvisorDto( advisor ) );
        }

        return list;
    }
}

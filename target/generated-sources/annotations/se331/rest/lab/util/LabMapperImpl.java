package se331.rest.lab.util;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import se331.rest.lab.dto.AdvisorDTO;
import se331.rest.lab.dto.OwnStudentDTO;
import se331.rest.lab.dto.OwnsAdvisorDTO;
import se331.rest.lab.dto.StudentDTO;
import se331.rest.lab.entity.Advisor;
import se331.rest.lab.entity.Student;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-10-22T22:10:56+0700",
    comments = "version: 1.5.5.Final, compiler: Eclipse JDT (IDE) 3.35.0.v20230814-2020, environment: Java 17.0.4.1 (Amazon.com Inc.)"
)
public class LabMapperImpl implements LabMapper {

    @Override
    public StudentDTO getStudentDto(Student student) {
        if ( student == null ) {
            return null;
        }

        StudentDTO.StudentDTOBuilder studentDTO = StudentDTO.builder();

        studentDTO.advisor( getAdvisorForStudent( student.getAdvisor() ) );
        studentDTO.department( student.getDepartment() );
        studentDTO.id( student.getId() );
        List<String> list = student.getImage();
        if ( list != null ) {
            studentDTO.image( new ArrayList<String>( list ) );
        }
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
        List<String> list = advisor.getImage();
        if ( list != null ) {
            advisorDTO.image( new ArrayList<String>( list ) );
        }
        advisorDTO.name( advisor.getName() );
        advisorDTO.studentList( studentListToOwnStudentDTOList( advisor.getStudentList() ) );
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

    @Override
    public OwnsAdvisorDTO getAdvisorForStudent(Advisor advisor) {
        if ( advisor == null ) {
            return null;
        }

        OwnsAdvisorDTO ownsAdvisorDTO = new OwnsAdvisorDTO();

        ownsAdvisorDTO.setAdvisorID( advisor.getAdvisorID() );
        ownsAdvisorDTO.setDepartment( advisor.getDepartment() );
        ownsAdvisorDTO.setId( advisor.getId() );
        ownsAdvisorDTO.setName( advisor.getName() );
        ownsAdvisorDTO.setPosition( advisor.getPosition() );
        ownsAdvisorDTO.setSurname( advisor.getSurname() );

        return ownsAdvisorDTO;
    }

    @Override
    public OwnStudentDTO getStudentForAdvisor(Student student) {
        if ( student == null ) {
            return null;
        }

        OwnStudentDTO ownStudentDTO = new OwnStudentDTO();

        ownStudentDTO.setId( student.getId() );
        ownStudentDTO.setName( student.getName() );
        ownStudentDTO.setStudentID( student.getStudentID() );
        ownStudentDTO.setSurname( student.getSurname() );

        return ownStudentDTO;
    }

    protected List<OwnStudentDTO> studentListToOwnStudentDTOList(List<Student> list) {
        if ( list == null ) {
            return null;
        }

        List<OwnStudentDTO> list1 = new ArrayList<OwnStudentDTO>( list.size() );
        for ( Student student : list ) {
            list1.add( getStudentForAdvisor( student ) );
        }

        return list1;
    }
}

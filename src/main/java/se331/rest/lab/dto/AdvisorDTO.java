package se331.rest.lab.dto;

import java.util.ArrayList;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AdvisorDTO {
    Long id;
    String name;
    String surname;
    String image;
    String department;
    String advisorID;
    List<OwnStudentDTO> studentList = new ArrayList<>();

}

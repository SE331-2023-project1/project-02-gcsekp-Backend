package se331.rest.lab.dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class StudentDTO {
    Long id;
    String name;
    String surname;
    String position;

    String department;
    OwnsAdvisorDTO advisor;
    List<String> image;

}

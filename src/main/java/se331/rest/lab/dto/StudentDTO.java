package se331.rest.lab.dto;

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
    String image;
    String department;
    OwnsAdvisorDTO advisor;

}

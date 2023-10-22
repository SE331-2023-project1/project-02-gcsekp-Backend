package se331.rest.lab.dto;

import com.google.auto.value.AutoValue.Builder;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class OwnsAdvisorDTO {
    Long id;
    String name;
    String surname;
    String department;
    String position;
    String advisorID;

}

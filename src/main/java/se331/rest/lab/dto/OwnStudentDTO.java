package se331.rest.lab.dto;

import com.google.auto.value.AutoValue.Builder;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class OwnStudentDTO {
    Long id;
    String studentID;
    String name;
    String surname;

}

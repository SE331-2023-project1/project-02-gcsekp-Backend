package se331.rest.lab.dto;

import java.util.ArrayList;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import se331.rest.lab.security.identity.Role;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class StudentAuthDTO {
    Long id;
    String name;
    List<Role> roles = new ArrayList<>();
}

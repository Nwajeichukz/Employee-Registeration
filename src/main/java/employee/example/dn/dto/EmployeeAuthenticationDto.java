package employee.example.dn.dto;

import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.validation.constraints.NotBlank;

@Data
@RequiredArgsConstructor
public class EmployeeAuthenticationDto {
    @NotBlank(message = "username can not be blank")
    private String username;
    @NotBlank(message = "username can not be blank")
    private String password;
}

package employee.example.dn.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
@AllArgsConstructor
public class PostEmployeeDto {

    @NotBlank(message = "fullname can not be blank")
    private String fullName;

    @NotBlank(message = "username can not be blank")
    private String username;
    @NotBlank(message = "password can not be blank")
    private String password;

    @NotBlank(message = "department can not be blank")
    private String department;

    @NotBlank(message = "designation can not be blank")
    private String designation;

    @javax.validation.constraints.Pattern(regexp = "((0?[1-9]|[12][0-9]|3[01])-(0?[1-9]|1[012])-([0-9]{4}))", message = "date of joining format dd-mm-yyyy")
    private String dateOfJoining;

    @javax.validation.constraints.Pattern(regexp = "((0?[1-9]|[12][0-9]|3[01])-(0?[1-9]|1[012])-([0-9]{4}))", message = "date of birth format dd-mm-yyyy")
    private String dateOfBirth;

    @javax.validation.constraints.Pattern(regexp = "(male|female)", message = "maritalStatus format should either be male/female")
    private String maritalStatus;

}

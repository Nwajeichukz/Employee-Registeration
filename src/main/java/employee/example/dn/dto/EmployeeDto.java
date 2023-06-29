package employee.example.dn.dto;

import employee.example.dn.entity.EmployeeUser;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

@Data
@AllArgsConstructor
public class EmployeeDto {

    private long id;

    private String fullName;

    private String username;

    private String department;

    private String designation;

    private String dateOfJoining;

    private String dateOfBirth;

    private String maritalStatus;

    public EmployeeDto(EmployeeUser employeeUser) {
        this.id = employeeUser.getId();
        this.fullName = employeeUser.getFullName();
        this.username = employeeUser.getUsername();
        this.department = employeeUser.getDepartment();
        this.designation = employeeUser.getDesignation();
        this.dateOfJoining = employeeUser.getDateOfJoining();
        this.dateOfBirth = employeeUser.getDateOfBirth();
        this.maritalStatus = employeeUser.getMaritalStatus();

    }
}

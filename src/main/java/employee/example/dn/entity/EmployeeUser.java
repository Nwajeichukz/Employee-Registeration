package employee.example.dn.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "EMPLOYEE")
public class EmployeeUser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "full_name", nullable = false)
    private String fullName;

    @Column(name = "username", nullable = false, unique = true)
    private String username;

    @Column(name = "password", nullable = false)
    private String password;

    @Column(name = "department", nullable = false)
    private String department;

    @Column(name = "designation", nullable = false)
    private String designation;

    @Column(name = "date_of_joining", nullable = false)
    private String dateOfJoining;

    @Column(name = "date_of_birth", nullable = false)
    private String dateOfBirth;

    @Column(name = "marital_status", nullable = false)
    private String maritalStatus;


}
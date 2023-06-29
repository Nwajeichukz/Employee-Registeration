package employee.example.dn.service.employee;

import employee.example.dn.dto.EmployeeAppResponse;
import employee.example.dn.dto.EmployeeDto;
import employee.example.dn.dto.PostEmployeeDto;
import employee.example.dn.entity.EmployeeUser;
import employee.example.dn.exception.ApiException;
import employee.example.dn.repository.EmployeeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class EmployeeService implements EmployeeServiceImpl{
    private final EmployeeRepository employeeRepository;

    @Override
    public EmployeeAppResponse<Map<String, Object>> getAll(Pageable pageable) {
        Page<EmployeeDto> em = employeeRepository.findAll(pageable).map(EmployeeDto::new);

        Map<String , Object> pages = Map.of(
                "page", em.getNumber(),
                "totalPages", em.getTotalPages(),
                "totalElements", em.getTotalElements(),
                "size", em.getSize(),
                "content", em.getContent()
        );


        return new EmployeeAppResponse<>(0, "Successful", pages);
    }


    @Override
    public EmployeeAppResponse<EmployeeDto> getById(long id){
        EmployeeUser emp = employeeRepository.findById(id).orElseThrow(() -> new ApiException("not found"));

        return new EmployeeAppResponse<>( "successfully retrieved", new EmployeeDto(emp));
    }

    @Override
    public EmployeeAppResponse<?> register(PostEmployeeDto postEmployeeDto){
        boolean check = employeeRepository.existsByUsername(postEmployeeDto.getUsername());

        if (check) throw new ApiException("user already exists");

        EmployeeUser emp = new EmployeeUser();

        emp.setFullName(postEmployeeDto.getFullName());
        emp.setUsername(postEmployeeDto.getUsername());
        emp.setPassword(postEmployeeDto.getPassword());
        emp.setDepartment(postEmployeeDto.getDepartment());
        emp.setDesignation(postEmployeeDto.getDesignation());
        emp.setDateOfJoining(postEmployeeDto.getDateOfJoining());
        emp.setDateOfBirth(postEmployeeDto.getDateOfBirth());
        emp.setMaritalStatus(postEmployeeDto.getMaritalStatus());


        employeeRepository.save(emp);
        return new EmployeeAppResponse<>(0, "Successful");
    }

    @Override
    public void deleteUser(long id) {
        employeeRepository.deleteById(id);
    }

    @Override
    public EmployeeAppResponse<?> updateUser(long id, PostEmployeeDto postEmployeeDto) {
        Optional<EmployeeUser> employee = employeeRepository.findById(id);

        if (employee.isPresent()){
           EmployeeUser emp = employee.get();

            emp.setFullName(postEmployeeDto.getFullName());
            emp.setUsername(postEmployeeDto.getUsername());
            emp.setPassword(postEmployeeDto.getPassword());
            emp.setDepartment(postEmployeeDto.getDepartment());
            emp.setDesignation(postEmployeeDto.getDesignation());
            emp.setDateOfJoining(postEmployeeDto.getDateOfJoining());
            emp.setDateOfBirth(postEmployeeDto.getDateOfBirth());
            emp.setMaritalStatus(postEmployeeDto.getMaritalStatus());

            employeeRepository.save(emp);
        }else {
            throw new ApiException("do not exists");
        }


        return new EmployeeAppResponse<>(0, "successful");
    }
}
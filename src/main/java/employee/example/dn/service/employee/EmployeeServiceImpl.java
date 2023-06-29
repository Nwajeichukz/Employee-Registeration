package employee.example.dn.service.employee;

import employee.example.dn.dto.EmployeeAppResponse;
import employee.example.dn.dto.EmployeeDto;
import employee.example.dn.dto.PostEmployeeDto;
import org.springframework.data.domain.Pageable;

import java.util.Map;

public interface EmployeeServiceImpl {
    EmployeeAppResponse<Map<String, Object>> getAll(Pageable pageable);
    EmployeeAppResponse<EmployeeDto> getById(long id);

    EmployeeAppResponse<?> register(PostEmployeeDto postEmployeeDto);
    void deleteUser(long id);
    EmployeeAppResponse<?> updateUser(long id, PostEmployeeDto postEmployeeDto);
}

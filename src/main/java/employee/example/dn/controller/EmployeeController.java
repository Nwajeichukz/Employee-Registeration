package employee.example.dn.controller;

import employee.example.dn.dto.EmployeeAppResponse;
import employee.example.dn.dto.PostEmployeeDto;
import employee.example.dn.service.employee.EmployeeService;
import employee.example.dn.service.employee.EmployeeServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Map;

@RestController
@RequestMapping("/employee")
@RequiredArgsConstructor
public class EmployeeController {
    private final EmployeeServiceImpl employeeService;

    @GetMapping
    public ResponseEntity<EmployeeAppResponse<Map<String, Object>>> getAll(
        @RequestParam(value = "page", required = false, defaultValue = "0")int page,
        @RequestParam(value = "size", required = false, defaultValue = "10")int size
    ){
        return ResponseEntity.ok(employeeService.getAll(PageRequest.of(page, size)));
    }

    @GetMapping("/{id}")
    public ResponseEntity<EmployeeAppResponse<?>> getById(@PathVariable long id){
        return ResponseEntity.ok(employeeService.getById(id));
    }

    @PatchMapping("/{id}")
    public ResponseEntity<EmployeeAppResponse<?>> updateUser(@PathVariable long id, @RequestBody PostEmployeeDto postEmployeeDto){
        return ResponseEntity.ok(employeeService.updateUser(id, postEmployeeDto));
    }


    @PostMapping("/create")
    public ResponseEntity<EmployeeAppResponse<?>> create(@Valid @RequestBody PostEmployeeDto postEmployeeDto){
        return ResponseEntity.ok(employeeService.register(postEmployeeDto));
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable long id){
        employeeService.deleteUser(id);
    }
}

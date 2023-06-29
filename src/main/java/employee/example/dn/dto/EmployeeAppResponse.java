package employee.example.dn.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
public class EmployeeAppResponse<T> {
    private int code;

    private String timestamp = String.valueOf(LocalDateTime.now());

    private String message;

    private T data;

    public EmployeeAppResponse(int code, String message) {
        this.code = code;
        this.message = message;
    }


    public EmployeeAppResponse(int code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public EmployeeAppResponse(String message, T data) {
        this.message = message;
        this.data = data;
    }
}

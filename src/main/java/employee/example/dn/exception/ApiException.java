package employee.example.dn.exception;

import lombok.Data;

@Data
public class ApiException extends RuntimeException{
    private String errMessage;

    public ApiException(String message) {
        super(message);
        this.errMessage = message;
    }


}

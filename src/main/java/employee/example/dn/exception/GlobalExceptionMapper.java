package employee.example.dn.exception;

import employee.example.dn.dto.EmployeeAppResponse;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Collections;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

@ControllerAdvice
public class GlobalExceptionMapper extends ResponseEntityExceptionHandler {

    @ExceptionHandler(ApiException.class)
    public ResponseEntity<EmployeeAppResponse<?>> handleEmptyInput (ApiException apiRequestException){
        return new ResponseEntity<>(
                new EmployeeAppResponse<>(apiRequestException.getMessage(), Collections.singletonList(apiRequestException.getMessage())),
                HttpStatus.BAD_REQUEST);
    }


    @ExceptionHandler(NoSuchElementException.class)
    public ResponseEntity<String> handleNoSuchElement (NoSuchElementException noSuchElementException){
        return new ResponseEntity<String>("NO VALUE IS PRESENT IN THE DB", HttpStatus.NOT_FOUND);
    }


    @Override
    protected ResponseEntity<Object> handleHttpRequestMethodNotSupported(HttpRequestMethodNotSupportedException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        return new ResponseEntity<Object>("PLEASE CHANGE HTTP RETURN TYPE", HttpStatus.NOT_FOUND);
    }

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        List<FieldError> fieldErrors = ex.getBindingResult().getFieldErrors();

        String responseDescription = fieldErrors.stream().map(FieldError::getDefaultMessage).collect(Collectors.joining(", "));
        EmployeeAppResponse response = new EmployeeAppResponse(1, responseDescription);
        return new ResponseEntity<>(response, headers, HttpStatus.BAD_REQUEST);
    }
}

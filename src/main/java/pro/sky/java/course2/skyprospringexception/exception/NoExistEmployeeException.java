package pro.sky.java.course2.skyprospringexception.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class NoExistEmployeeException extends RuntimeException{
    public NoExistEmployeeException(String message) {
        super();
    }
}

package eng.core.binksake.common;

import eng.core.binksake.common.exception.ErrorMessageDTO;
import eng.core.binksake.common.exception.UserAlreadyExistsException;
import eng.core.binksake.common.exception.UserNotAuthenticatedException;
import eng.core.binksake.common.exception.UserNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionHandler {
    @org.springframework.web.bind.annotation.ExceptionHandler({
            UserNotFoundException.class,
            UserNotAuthenticatedException.class,
            UserAlreadyExistsException.class
    })
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ErrorMessageDTO handleExceptions(Exception e) {
        return new ErrorMessageDTO(e.getMessage());
    }
}

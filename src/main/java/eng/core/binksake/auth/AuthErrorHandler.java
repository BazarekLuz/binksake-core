package eng.core.binksake.auth;

import eng.core.binksake.common.exception.ErrorMessageDTO;
import eng.core.binksake.common.exception.UserNotAuthenticatedException;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class AuthErrorHandler {

    @ExceptionHandler({BadCredentialsException.class})
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorMessageDTO handleBadCredentials(Exception e) {
        return new ErrorMessageDTO(e.getMessage());
    }

    @ExceptionHandler({UserNotAuthenticatedException.class})
    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    public ErrorMessageDTO handleNotAuthenticated(Exception e) {
        return new ErrorMessageDTO(e.getMessage());
    }
}

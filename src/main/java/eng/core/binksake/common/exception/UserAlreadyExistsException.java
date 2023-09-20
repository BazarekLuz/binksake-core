package eng.core.binksake.common.exception;

import eng.core.binksake.common.ErrorMessages;

public class UserAlreadyExistsException extends RuntimeException {
    public UserAlreadyExistsException() {
        super(ErrorMessages.USER_ALREADY_EXISTS);
    }
}

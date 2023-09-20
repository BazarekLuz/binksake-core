package eng.core.binksake.common.exception;

import eng.core.binksake.common.ErrorMessages;

public class UserNotFoundException extends RuntimeException {
    public UserNotFoundException() {
        super(ErrorMessages.USER_NOT_FOUND);
    }
}

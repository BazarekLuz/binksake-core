package eng.core.binksake.common.exception;

import eng.core.binksake.common.ErrorMessages;

public class UserNotAuthenticatedException extends RuntimeException {
    public UserNotAuthenticatedException() {
        super(ErrorMessages.NOT_AUTHENTICATED);
    }
}

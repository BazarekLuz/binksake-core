package eng.core.binksake.common.exception;

import eng.core.binksake.common.ErrorMessages;

public class EmailAlreadyExistsException extends RuntimeException {
    public EmailAlreadyExistsException() {
        super(ErrorMessages.EMAIL_ALREADY_EXISTS);
    }
}

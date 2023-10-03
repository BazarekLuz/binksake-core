package eng.core.binksake.common.exception;

import eng.core.binksake.common.ErrorMessages;

public class NameAlreadyExistsException extends RuntimeException {
    public NameAlreadyExistsException() {
        super(ErrorMessages.NAME_ALREADY_EXISTS);
    }
}

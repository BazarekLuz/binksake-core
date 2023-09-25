package eng.core.binksake.common.exception;

import eng.core.binksake.common.ErrorMessages;

public class AlbumNotFoundException extends RuntimeException {
    public AlbumNotFoundException() {
        super(ErrorMessages.ALBUM_NOT_FOUND);
    }
}

package eng.core.binksake.common.exception;

import eng.core.binksake.common.ErrorMessages;

public class SongNotFoundException extends RuntimeException {
    public SongNotFoundException() {
        super(ErrorMessages.SONG_NOT_FOUND);
    }
}

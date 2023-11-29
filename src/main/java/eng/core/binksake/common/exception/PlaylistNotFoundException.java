package eng.core.binksake.common.exception;

import eng.core.binksake.common.ErrorMessages;

public class PlaylistNotFoundException extends RuntimeException {
    public PlaylistNotFoundException() {
        super(ErrorMessages.PLAYLIST_NOT_FOUND);
    }
}

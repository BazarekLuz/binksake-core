package eng.core.binksake.common.exception;

import eng.core.binksake.common.ErrorMessages;

public class ArtistNotFoundException extends RuntimeException {
    public ArtistNotFoundException() {
        super(ErrorMessages.ARTIST_NOT_FOUND);
    }
}

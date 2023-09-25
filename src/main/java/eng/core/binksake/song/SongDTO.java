package eng.core.binksake.song;

import eng.core.binksake.artist.ArtistDTO;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class SongDTO {
    private String name;
    private String path;
    private List<ArtistDTO> artistDTOs;
}

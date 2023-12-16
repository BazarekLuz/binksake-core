package eng.core.binksake.song;

import eng.core.binksake.artist.ArtistDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Time;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SearchSongDTO {
    private String name;
    private String path;
    private Time duration;
    private String albumCoverUrl;
    private Long albumId;
    private List<ArtistDTO> artists;
}

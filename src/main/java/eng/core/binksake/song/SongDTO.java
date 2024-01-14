package eng.core.binksake.song;

import eng.core.binksake.album.Album;
import eng.core.binksake.artist.ArtistDTO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalTime;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SongDTO {
    private Long id;
    private String name;
    private String path;
    private LocalTime duration;
    private String albumCoverUrl;
    private Long albumId;
    private List<ArtistDTO> artistDTOs;
}

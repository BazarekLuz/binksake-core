package eng.core.binksake.search;

import eng.core.binksake.album.AlbumRepository;
import eng.core.binksake.album.SearchAlbumDTO;
import eng.core.binksake.artist.ArtistDTO;
import eng.core.binksake.artist.ArtistRepository;
import eng.core.binksake.common.AutoMapper;
import eng.core.binksake.common.exception.ArtistNotFoundException;
import eng.core.binksake.song.SearchSongDTO;
import eng.core.binksake.song.SongDTO;
import eng.core.binksake.song.SongRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.sql.Time;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class SearchService {
    private final ArtistRepository artistRepository;
    private final AlbumRepository albumRepository;
    private final SongRepository songRepository;
    private final AutoMapper autoMapper;

    List<SongDTO> findSongsByPhrase(String phrase) {
        return songRepository.findSongsByPhrase(phrase).stream()
                .map(song -> new SongDTO(
                        song.get(0, Long.class),
                        song.get(1, String.class),
                        song.get(2, String.class),
                        song.get(3, Time.class).toLocalTime(),
                        song.get(4, String.class),
                        song.get(5, Long.class),
                        convertToArtistDTOList(song.get(6, Long[].class))))
                .collect(Collectors.toList());
    }

    List<SearchAlbumDTO> findAlbumsByPhrase(String phrase) {
        return albumRepository.findAlbumsByPhrase(phrase).stream()
                .map(album -> new SearchAlbumDTO(
                        album.get(0, Long.class),
                        album.get(1, String.class),
                        album.get(2, Date.class),
                        album.get(3, String.class)))
                .collect(Collectors.toList());
    }

    List<ArtistDTO> findArtistsByPhrase(String phrase) {
        return artistRepository.findArtistsByPhrase(phrase).stream()
                .map(artist -> new ArtistDTO(
                        artist.get(0, Long.class),
                        artist.get(1, String.class),
                        artist.get(2, String.class)))
                .collect(Collectors.toList());
    }

    private List<ArtistDTO> convertToArtistDTOList(Long[] artistsId) {
        return Arrays.stream(artistsId)
                .map(artistId -> artistRepository.findById(artistId).orElseThrow(ArtistNotFoundException::new))
                .map(autoMapper::mapToArtistDTO)
                .collect(Collectors.toList());
    }
}

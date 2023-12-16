package eng.core.binksake.album;

import eng.core.binksake.artist.ArtistDTO;
import eng.core.binksake.common.AutoMapper;
import eng.core.binksake.common.exception.AlbumNotFoundException;
import eng.core.binksake.song.SongDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class AlbumService {
    private final AlbumRepository albumRepository;
    private final AutoMapper autoMapper;

    AlbumDTO fetchAlbumDetails(Long id) {
        return autoMapper.mapToAlbumDTO(albumRepository.findById(id)
                .orElseThrow(AlbumNotFoundException::new));
    }

    Set<ArtistDTO> fetchAlbumArtists(Long id) {
        Album album = albumRepository.findById(id)
                .orElseThrow(AlbumNotFoundException::new);
        return album.getArtists().stream()
                .map(autoMapper::mapToArtistDTO)
                .collect(Collectors.toSet());
    }

    List<SongDTO> fetchAlbumSongs(Long id) {
        Album album = albumRepository.findById(id)
                .orElseThrow(AlbumNotFoundException::new);
        return album.getSongs().stream()
                .map(autoMapper::mapToSongDTO)
                .toList();
    }
}

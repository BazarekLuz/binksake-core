package eng.core.binksake.artist;

import eng.core.binksake.album.AlbumDTO;
import eng.core.binksake.common.AutoMapper;
import eng.core.binksake.common.exception.ArtistNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ArtistService {
    private final ArtistRepository artistRepository;
    private final AutoMapper autoMapper;

    public ArtistDTO fetchArtist(Long id) {
        return autoMapper.mapToArtistDTO(
                artistRepository.findById(id)
                .orElseThrow(ArtistNotFoundException::new));
    }

    public List<AlbumDTO> fetchAlbums(Long id) {
        Artist artist = artistRepository.findById(id)
                .orElseThrow(ArtistNotFoundException::new);
        return artist.getAlbums().stream()
                .map(autoMapper::mapToAlbumDTO)
                .toList();
    }
}

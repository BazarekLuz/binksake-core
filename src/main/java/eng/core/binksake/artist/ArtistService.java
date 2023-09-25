package eng.core.binksake.artist;

import eng.core.binksake.common.AutoMapper;
import eng.core.binksake.common.exception.ArtistNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

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
}

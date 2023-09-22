package eng.core.binksake.artist;

import eng.core.binksake.common.AutoMapper;
import eng.core.binksake.common.exception.ArtistNotFoundException;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.hibernate.Hibernate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ArtistService {
    private final ArtistRepository artistRepository;
    private final AutoMapper autoMapper;

    public ArtistDTO fetchArtistByName(String name) {
        return autoMapper.mapToArtistDTO(
                artistRepository.findByName(name)
                .orElseThrow(ArtistNotFoundException::new));
    }
}

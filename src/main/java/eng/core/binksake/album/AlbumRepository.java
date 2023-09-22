package eng.core.binksake.album;

import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface AlbumRepository extends CrudRepository<Album, Long> {
    Optional<Album> findAlbumByName(String name);
}

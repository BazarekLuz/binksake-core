package eng.core.binksake.album;

import eng.core.binksake.song.Song;
import eng.core.binksake.song.SongDTO;
import jakarta.persistence.Tuple;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface AlbumRepository extends CrudRepository<Album, Long> {
    Optional<Album> findAlbumByName(String name);

    @Query(value = """
            SELECT ID, NAME, DATE_CREATED, IMG_URL
            FROM ALBUM
            WHERE REPLACE(LOWER(NAME), ' ', '') LIKE REPLACE(LOWER(:phrase), ' ', '')
            GROUP BY ID
            """, nativeQuery = true)
    List<Tuple> findAlbumsByPhrase(String phrase);
}

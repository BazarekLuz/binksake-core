package eng.core.binksake.artist;

import jakarta.persistence.Tuple;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface ArtistRepository extends CrudRepository<Artist, Long> {
    Optional<Artist> findByName(String name);

    @Query(value = """
            SELECT ID, NAME, IMG_URL
            FROM ARTIST
            WHERE REPLACE(LOWER(NAME), ' ', '') LIKE REPLACE(LOWER(:phrase), ' ', '')
            GROUP BY ID
            """, nativeQuery = true)
    List<Tuple> findArtistsByPhrase(String phrase);
}

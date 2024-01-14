package eng.core.binksake.song;

import jakarta.persistence.Tuple;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface SongRepository extends CrudRepository<Song, Long> {
    @Query(value = """
            SELECT s.ID, s.NAME, s.PATH, s.DURATION, s.ALBUM_COVER_URL, s.ALBUM_ID, ARRAY_AGG(sa.ARTIST_ID) AS ARTIST_IDS
            FROM SONG s
            JOIN SONG_ARTIST sa ON s.ID = sa.SONG_ID
            WHERE REPLACE(LOWER(NAME), ' ', '') LIKE REPLACE(LOWER(:phrase), ' ', '')
            GROUP BY s.ID
            """, nativeQuery = true)
    List<Tuple> findSongsByPhrase(String phrase);
}

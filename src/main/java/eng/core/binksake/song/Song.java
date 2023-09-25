package eng.core.binksake.song;

import eng.core.binksake.artist.Artist;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
public class Song {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String path;
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "song_artist",
            joinColumns = @JoinColumn(name = "song_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "artist_id", referencedColumnName = "id"))
    private List<Artist> artistList;
}

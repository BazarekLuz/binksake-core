package eng.core.binksake.album;

import eng.core.binksake.artist.Artist;
import eng.core.binksake.song.Song;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Album {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private LocalDate dateCreated;
    private String imgUrl;

    @OneToMany(cascade = {CascadeType.REMOVE, CascadeType.PERSIST}, fetch = FetchType.LAZY)
    @JoinColumn(name = "album_id")
    private List<Song> songs = new ArrayList<>();


    @ManyToMany(cascade = {CascadeType.ALL})
    @JoinTable(name="album_artist",
            joinColumns = @JoinColumn(name = "album_id"),
            inverseJoinColumns = @JoinColumn(name = "artist_id"))
    private List<Artist> artists = new ArrayList<>();
}

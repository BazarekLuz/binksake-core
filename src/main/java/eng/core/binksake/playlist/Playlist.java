package eng.core.binksake.playlist;

import eng.core.binksake.song.Song;
import eng.core.binksake.user.User;
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
public class Playlist {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String imgUrl;
    private String name;
    private LocalDate dateCreated;

    @ManyToOne
    @JoinColumn(name = "owner_id")
    private User ownerId;

    @ManyToMany
    @JoinTable(name = "playlist_song",
            joinColumns = @JoinColumn(name="playlist_id"),
            inverseJoinColumns = @JoinColumn(name="song_id"))
    private List<Song> songs = new ArrayList<>();

    public void addSong(Song song) {
        this.getSongs().add(song);
    }
}

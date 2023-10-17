package eng.core.binksake.artist;

import eng.core.binksake.album.Album;
import jakarta.annotation.Nullable;
import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
public class Artist {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @Nullable
    private String basicInfo;
    @ManyToMany(cascade = {CascadeType.REMOVE}, mappedBy = "artists")
    private List<Album> albums = new ArrayList<>();

    public void addAlbum(Album album) {
        this.getAlbums().add(album);
    }
}

package eng.core.binksake.album;

import eng.core.binksake.artist.ArtistDTO;
import eng.core.binksake.song.SongDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/api/albums")
@RequiredArgsConstructor
public class AlbumController {
    private final AlbumService albumService;
    @GetMapping("/{id}")
    private ResponseEntity<AlbumDTO> viewAlbumDetails(@PathVariable Long id) {
        return ResponseEntity.ok(albumService.fetchAlbumDetails(id));
    }

    @GetMapping("/{id}/authors")
    private ResponseEntity<Set<ArtistDTO>> viewAlbumAuthors(@PathVariable Long id) {
        return ResponseEntity.ok(albumService.fetchAlbumArtists(id));
    }


    @GetMapping("/{id}/songs")
    private ResponseEntity<List<SongDTO>> viewAlbumSongs(@PathVariable Long id) {
        return ResponseEntity.ok(albumService.fetchAlbumSongs(id));
    }
}

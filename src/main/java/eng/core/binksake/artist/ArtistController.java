package eng.core.binksake.artist;

import eng.core.binksake.album.AlbumDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/artists")
public class ArtistController {
    private final ArtistService artistService;
    @GetMapping("/{id}")
    private ResponseEntity<ArtistDTO> viewArtist(@PathVariable Long id) {
        return ResponseEntity.ok(artistService.fetchArtist(id));
    }

    @GetMapping("/{id}/albums")
    private ResponseEntity<List<AlbumDTO>> viewAlbums(@PathVariable Long id) {
        return ResponseEntity.ok(artistService.fetchAlbums(id));
    }
}

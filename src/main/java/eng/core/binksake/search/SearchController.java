package eng.core.binksake.search;

import eng.core.binksake.album.SearchAlbumDTO;
import eng.core.binksake.artist.ArtistDTO;
import eng.core.binksake.song.SearchSongDTO;
import eng.core.binksake.song.SongDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/search")
public class SearchController {
    private final SearchService searchService;

    @GetMapping("songs")
    private ResponseEntity<List<SongDTO>> getSongsByPhrase(
            @RequestParam(name = "phrase") String phrase) {
        return ResponseEntity.ok(searchService.findSongsByPhrase("%" + phrase + "%"));
    }

    @GetMapping("albums")
    private ResponseEntity<List<SearchAlbumDTO>> getAlbumsByPhrase(
            @RequestParam(name = "phrase") String phrase)  {
        return ResponseEntity.ok(searchService.findAlbumsByPhrase("%" + phrase + "%"));
    }

    @GetMapping("artists")
    private ResponseEntity<List<ArtistDTO>> getArtistsByPhrase(
            @RequestParam(name = "phrase") String phrase) {
        return ResponseEntity.ok(searchService.findArtistsByPhrase("%" + phrase + "%"));
    }
}

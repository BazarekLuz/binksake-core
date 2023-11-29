package eng.core.binksake.playlist;

import eng.core.binksake.song.SongDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.parameters.P;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/playlists")
public class PlaylistController {
    private final PlaylistService playlistService;
    private final PlaylistUserService playlistUserService;

    @GetMapping("/{id}")
    private ResponseEntity<PlaylistDTO> getPlaylist(@PathVariable Long id) {
        return ResponseEntity.ok(playlistService.fetchPlaylist(id));
    }

    @GetMapping("/{id}/songs")
    private ResponseEntity<List<SongDTO>> getPlaylistSongs(@PathVariable Long id) {
        return ResponseEntity.ok(playlistService.fetchPlaylistSongs(id));
    }

    @GetMapping
    private ResponseEntity<List<PlaylistDTO>> getUserPlaylists(@RequestParam(name = "ownerId") Long ownerId) {
        return ResponseEntity.ok(playlistUserService.fetchUserPlaylists(ownerId));
    }

    @PostMapping("/create")
    @ResponseStatus(HttpStatus.CREATED)
    private void createPlaylist(@RequestBody AddPlaylistDTO addPlaylistDTO) {
        playlistUserService.addPlaylist(addPlaylistDTO);
    }

    @PatchMapping("/update")
    @ResponseStatus(HttpStatus.OK)
    private void addSongToPlaylist(@RequestParam Long playlistId, @RequestParam Long songId) {
        playlistService.addSongToPlaylist(playlistId, songId);
    }

    @DeleteMapping("/remove-song")
    @ResponseStatus(HttpStatus.OK)
    private void removeSongFromPlaylist(@RequestParam Long playlistId, @RequestParam Long songId) {
        playlistService.removeSongFromPlaylist(playlistId, songId);
    }

    @DeleteMapping("/remove")
    @ResponseStatus(HttpStatus.OK)
    private void removePlaylist(@RequestParam Long playlistId) {
        playlistService.removePlaylist(playlistId);
    }

}

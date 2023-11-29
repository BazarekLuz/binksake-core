package eng.core.binksake.playlist;

import eng.core.binksake.common.AutoMapper;
import eng.core.binksake.common.exception.PlaylistNotFoundException;
import eng.core.binksake.common.exception.SongNotFoundException;
import eng.core.binksake.song.Song;
import eng.core.binksake.song.SongDTO;
import eng.core.binksake.song.SongRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.parameters.P;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PlaylistService {
    private final PlaylistRepository playlistRepository;
    private final SongRepository songRepository;
    private final AutoMapper autoMapper;

    public PlaylistDTO fetchPlaylist(Long id) {
        return autoMapper.mapToPlaylistDTO(
                playlistRepository.findById(id)
                .orElseThrow(PlaylistNotFoundException::new));
    }

    public List<SongDTO> fetchPlaylistSongs(Long id) {
        Playlist playlist = playlistRepository.findById(id)
                .orElseThrow(PlaylistNotFoundException::new);
        return playlist.getSongs().stream()
                .map(autoMapper::mapToSongDTO)
                .toList();
    }

    public void addSongToPlaylist(Long playlistId, Long songId) {
        Playlist playlist = playlistRepository.findById(playlistId)
                .orElseThrow(PlaylistNotFoundException::new);

        Song song = songRepository.findById(songId)
                .orElseThrow(SongNotFoundException::new);

        playlist.addSong(song);
        playlistRepository.save(playlist);
    }

    public void removeSongFromPlaylist(Long playlistId, Long songId) {
        Playlist playlist = playlistRepository.findById(playlistId)
                .orElseThrow(PlaylistNotFoundException::new);

        Song removedSong = songRepository.findById(songId)
                .orElseThrow(SongNotFoundException::new);

        playlist.getSongs().remove(removedSong);
        playlistRepository.save(playlist);
    }

    public void removePlaylist(Long playlistId) {
        playlistRepository.deleteById(playlistId);
    }
}

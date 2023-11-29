package eng.core.binksake.playlist;

import eng.core.binksake.common.AutoMapper;
import eng.core.binksake.common.exception.UserNotFoundException;
import eng.core.binksake.user.User;
import eng.core.binksake.user.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class PlaylistUserService {
    private final UserRepository userRepository;
    private final PlaylistRepository playlistRepository;
    private final AutoMapper autoMapper;

    public List<PlaylistDTO> fetchUserPlaylists(Long ownerId) {
        User user = userRepository.findById(ownerId)
                .orElseThrow(UserNotFoundException::new);
        return user.getPlaylists().stream()
                .map(autoMapper::mapToPlaylistDTO)
                .toList();
    }

    public void addPlaylist(AddPlaylistDTO addPlaylistDTO) {
        User playlistOwner = userRepository.findById(addPlaylistDTO.getOwnerId())
                .orElseThrow(UserNotFoundException::new);

        Playlist savedPlaylist = Playlist.builder()
                .name(addPlaylistDTO.getName())
                .ownerId(playlistOwner)
                .dateCreated(LocalDate.now())
                .songs(new ArrayList<>())
                .build();
        playlistRepository.save(savedPlaylist);
    }
}

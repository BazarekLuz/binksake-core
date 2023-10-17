package eng.core.binksake.common;

import eng.core.binksake.album.Album;
import eng.core.binksake.album.AlbumDTO;
import eng.core.binksake.artist.Artist;
import eng.core.binksake.artist.ArtistDTO;
import eng.core.binksake.song.Song;
import eng.core.binksake.song.SongDTO;
import eng.core.binksake.user.User;
import eng.core.binksake.user.UserDTO;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class AutoMapper {
    private final ModelMapper modelMapper;

    public UserDTO mapToUserDTO(User user) {
        return modelMapper.map(user, UserDTO.class);
    }

    public ArtistDTO mapToArtistDTO(Artist artist) {
        return modelMapper.map(artist, ArtistDTO.class);
    }

    public AlbumDTO mapToAlbumDTO(Album album) {
        return modelMapper.map(album, AlbumDTO.class);
    }

    public SongDTO mapToSongDTO(Song song) {
        return SongDTO.builder()
                .name(song.getName())
                .path(song.getPath())
                .duration(song.getDuration())
                .albumId(song.getAlbumId().getId())
                .albumCoverUrl(song.getAlbumCoverUrl())
                .artistDTOs(song.getArtists().stream()
                        .map(this::mapToArtistDTO)
                        .collect(Collectors.toList()))
                .build();
    }
}

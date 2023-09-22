package eng.core.binksake.common;

import eng.core.binksake.artist.Artist;
import eng.core.binksake.artist.ArtistDTO;
import eng.core.binksake.auth.LoginRequestDTO;
import eng.core.binksake.user.RegisterUserDTO;
import eng.core.binksake.user.User;
import eng.core.binksake.user.UserDTO;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

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
}

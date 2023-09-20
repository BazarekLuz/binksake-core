package eng.core.binksake.common;

import eng.core.binksake.auth.LoginRequestDto;
import eng.core.binksake.auth.RegisterRequestDto;
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
    public User mapToUser(RegisterRequestDto registerRequestDto) {
        return modelMapper.map(registerRequestDto, User.class);
    }

    public User mapToUsers(UserDTO userDTO) {
        return modelMapper.map(userDTO, User.class);
    }

    public LoginRequestDto mapToLoginRequestDTO(RegisterRequestDto registerRequestDto) {
        return modelMapper.map(registerRequestDto, LoginRequestDto.class);
    }
}

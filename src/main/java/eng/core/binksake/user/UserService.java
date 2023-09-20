package eng.core.binksake.user;

import eng.core.binksake.auth.*;
import eng.core.binksake.common.AutoMapper;
import eng.core.binksake.common.exception.UserAlreadyExistsException;
import eng.core.binksake.common.exception.UserNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final AutoMapper autoMapper;
    private final AuthService authService;

    public JwtTokenDto register(RegisterRequestDto registerRequestDto) {
        userRepository.findByEmail(registerRequestDto.getEmail()).ifPresent(user -> {
            throw new UserAlreadyExistsException();
        });
        userRepository.save(autoMapper.mapToUser(registerRequestDto));
        // todo change this for more basic, do not merge register with login
//        User user = User.builder()
//                .name(request.getName())
//                .email(request.getEmail())
//                .password(passwordEncoder.encode(request.getPassword()))
//                .role(Role.USER)
//                .build();
//        userRepository.save(user);
//        String jwtToken = jwtService.generateToken(user);
//        return AuthenticationResponse.builder()
//                .token(jwtToken)
//                .build();
        LoginRequestDto loginRequestDto = autoMapper.mapToLoginRequestDTO(registerRequestDto);
        return authService.login(loginRequestDto);
    }
    UserDTO findUserById(Long id) {
        return autoMapper.mapToUserDTO(userRepository.findById(id)
                .orElseThrow(UserNotFoundException::new));
    }
}

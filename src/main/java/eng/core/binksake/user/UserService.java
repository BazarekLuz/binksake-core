package eng.core.binksake.user;

import eng.core.binksake.common.AutoMapper;
import eng.core.binksake.common.exception.EmailAlreadyExistsException;
import eng.core.binksake.common.exception.NameAlreadyExistsException;
import eng.core.binksake.common.exception.UserNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final AutoMapper autoMapper;
    private final PasswordEncoder passwordEncoder;


    void register(RegisterUserDTO registerUserDTO) {
        userRepository.findByEmail(registerUserDTO.getEmail()).ifPresent(user -> {
            throw new EmailAlreadyExistsException();
        });
        userRepository.findByName(registerUserDTO.getName()).ifPresent(user -> {
            throw new NameAlreadyExistsException();
        });

        User user = User.builder()
                .name(registerUserDTO.getName())
                .email(registerUserDTO.getEmail())
                .password(passwordEncoder.encode(registerUserDTO.getPassword()))
                .build();
        userRepository.save(user);
    }

    UserDTO findUserById(Long id) {
        return autoMapper.mapToUserDTO(userRepository.findById(id)
                .orElseThrow(UserNotFoundException::new));
    }

    List<UserDTO> findFriendsByUserId(Long id) {
        User user = userRepository.findById(id)
                .orElseThrow(UserNotFoundException::new);
        return user.getFriends().stream()
                .map(autoMapper::mapToUserDTO)
                .toList();
    }
}

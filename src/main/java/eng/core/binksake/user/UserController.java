package eng.core.binksake.user;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/users")
public class UserController {
    private final UserService userService;

    @PostMapping("/register")
    @ResponseStatus(HttpStatus.CREATED)
    private void register(@RequestBody RegisterUserDTO registerUserDTO) {
        userService.register(registerUserDTO);
    }

    @GetMapping("/{id}")
    private ResponseEntity<UserDTO> getUserById(@PathVariable Long id) {
        return ResponseEntity.ok(userService.findUserById(id));
    }

    @GetMapping("/{id}/friends")
    private ResponseEntity<List<UserDTO>> getFriendsByUserId(@PathVariable Long id) {
        return ResponseEntity.ok(userService.findFriendsByUserId(id));
    }
}

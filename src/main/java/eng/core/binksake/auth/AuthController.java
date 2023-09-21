package eng.core.binksake.auth;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/auth")
@RequiredArgsConstructor
public class AuthController {
    private final AuthService authService;

    @PostMapping("/login")
    @ResponseStatus(HttpStatus.OK)
    public JwtTokenDto login(@Valid @RequestBody LoginRequestDto loginRequestDto) {
        return authService.login(loginRequestDto);
    }

    @PostMapping("/refresh-token")
    @ResponseStatus(HttpStatus.OK)
    public JwtTokenDto refreshToken(HttpServletRequest request, HttpServletResponse response) {
        return authService.refreshToken(request, response);
    }

}

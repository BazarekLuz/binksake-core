package eng.core.binksake.auth;

import eng.core.binksake.common.ErrorMessages;
import eng.core.binksake.common.exception.UserNotAuthenticatedException;
import eng.core.binksake.common.exception.UserNotFoundException;
import eng.core.binksake.user.User;
import eng.core.binksake.user.UserRepository;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.security.SignatureException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class AuthService {
    private final UserRepository userRepository;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;

    public JwtTokenDTO login(LoginRequestDTO loginRequestDto) {
        Authentication authentication;
        try {
            authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            loginRequestDto.getEmail(),
                            loginRequestDto.getPassword()));
        } catch (AuthenticationException e) {
            throw new BadCredentialsException(ErrorMessages.BAD_CREDENTIALS);
        }
        User user = (User) authentication.getPrincipal();

        String jwtToken = jwtService.generateToken(user ,generateExtraClaims(user));
        String refreshToken = jwtService.generateRefresh(user);

        return JwtTokenDTO.builder()
                .token(jwtToken)
                .refreshToken(refreshToken)
                .build();
    }

    JwtTokenDTO refreshToken(HttpServletRequest request, HttpServletResponse response) {
        String authHeader = request.getHeader(HttpHeaders.AUTHORIZATION);

        if (authHeader == null || !authHeader.startsWith("Bearer ")) {
            throw new UserNotAuthenticatedException();
        }

        String refreshToken = authHeader.substring(7);
        String userEmail;

        try {
            userEmail = jwtService.extractUsername(refreshToken);
        } catch (ExpiredJwtException | SignatureException | MalformedJwtException e) {
            throw new UserNotAuthenticatedException();
        }

        if (userEmail == null) {
            throw new UserNotAuthenticatedException();
        }

        User user = userRepository.findByEmail(userEmail).orElseThrow(UserNotFoundException::new);

        if (!jwtService.isTokenValid(refreshToken, user)) {
            throw new UserNotAuthenticatedException();
        }

        String jwtToken = jwtService.generateToken(user, generateExtraClaims(user));

        return JwtTokenDTO.builder()
                .token(jwtToken)
                .refreshToken(refreshToken)
                .build();
    }

    private Map<String, Object> generateExtraClaims(User user) {
        Map<String, Object> extraClaims = new HashMap<>();
        extraClaims.put("id", user.getId());
        extraClaims.put("name", user.getName());

        if (user.getActivationTime() == null) {
            extraClaims.put("activationTime", null);
        } else {
            extraClaims.put("activationTime", user.getActivationTime().toString());
        }
        return extraClaims;
    }
}

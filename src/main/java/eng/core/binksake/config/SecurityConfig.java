package eng.core.binksake.config;

import eng.core.binksake.auth.CustomAuthenticationEntryPoint;
import eng.core.binksake.auth.JwtAuthenticationFilter;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig implements WebMvcConfigurer {
    private final JwtAuthenticationFilter jwtAuthFilter;
    private final AuthenticationProvider authenticationProvider;
    private final CustomAuthenticationEntryPoint authEntryPoint;

    @Value("${app.frontUrl}")
    private String frontUrl;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.csrf(AbstractHttpConfigurer::disable);

        http.authorizeHttpRequests(requests -> requests
                .requestMatchers(new AntPathRequestMatcher("/**", HttpMethod.OPTIONS.name())).permitAll()
                .requestMatchers(new AntPathRequestMatcher("/api/users/register")).permitAll()
                .requestMatchers(new AntPathRequestMatcher("/api/auth/login")).permitAll()
                .requestMatchers(new AntPathRequestMatcher("/api/artists/**")).permitAll()
                .requestMatchers(new AntPathRequestMatcher("/api/users/{id}")).authenticated()
                .requestMatchers(new AntPathRequestMatcher("/api/albums/**")).permitAll()
                .requestMatchers(new AntPathRequestMatcher("/api/audio")).permitAll()
                .requestMatchers(new AntPathRequestMatcher("/api/playlists")).permitAll()
                .requestMatchers(new AntPathRequestMatcher("/api/search")).permitAll()
                .anyRequest().permitAll()).headers().frameOptions().disable();

        http.sessionManagement(session ->
                session.sessionCreationPolicy(SessionCreationPolicy.STATELESS));

        http.headers().frameOptions().sameOrigin();

        http.exceptionHandling(exception -> exception.authenticationEntryPoint(authEntryPoint));

        http.authenticationProvider(authenticationProvider);
        http.addFilterBefore(jwtAuthFilter, UsernamePasswordAuthenticationFilter.class);

        return http.build();
    }

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry
                .addMapping("/**")
                .allowedMethods("*")
                .allowedOrigins(frontUrl);
    }
}

package hackerton.refactor.general.security.config;

import hackerton.refactor.general.security.filter.ExceptionHandlerFilter;
import hackerton.refactor.general.security.filter.JwtAuthenticationFilter;
import hackerton.refactor.general.security.filter.LoginFilter;
import hackerton.refactor.general.security.handler.LoginFailureHandler;
import hackerton.refactor.general.security.handler.LoginSuccessHandler;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@RequiredArgsConstructor
public class SecurityConfig {

    private final JwtAuthenticationFilter jwtAuthenticationFilter;
    private final LoginSuccessHandler loginSuccessHandler;
    private final LoginFailureHandler loginFailureHandler;
    private final ExceptionHandlerFilter exceptionHandlerFilter;

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http , AuthenticationConfiguration configuration) throws Exception {
        AuthenticationManager authenticationManager = configuration.getAuthenticationManager();
        LoginFilter loginFilter = new LoginFilter(authenticationManager, loginSuccessHandler, loginFailureHandler);

        http
                .csrf(csrf -> csrf.disable())
                .formLogin(form -> form.disable())
                .httpBasic(httpBasic -> httpBasic.disable())
                .cors(cors -> {
                })
                .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/auth/login").permitAll()
                        .requestMatchers("/auth/member-info").permitAll()
                        .requestMatchers(HttpMethod.POST , "/email").permitAll()
                        .anyRequest().authenticated()
                );

        http
                .addFilterBefore(exceptionHandlerFilter, UsernamePasswordAuthenticationFilter.class) // 최상단 예외 처리
                .addFilterBefore(loginFilter, UsernamePasswordAuthenticationFilter.class)           // 로그인 처리
                .addFilterBefore(jwtAuthenticationFilter, UsernamePasswordAuthenticationFilter.class); // JWT 인증
        return http.build();
    }
}

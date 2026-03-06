package hackerton.refactor.general.security.filter;

import hackerton.refactor.general.security.LoginRequest;
import hackerton.refactor.general.security.handler.LoginFailureHandler;
import hackerton.refactor.general.security.handler.LoginSuccessHandler;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@RequiredArgsConstructor
@Slf4j
public class LoginFilter extends UsernamePasswordAuthenticationFilter {
    public LoginFilter(AuthenticationManager authenticationManager,
                       LoginSuccessHandler loginSuccessHandler,
                       LoginFailureHandler failureHandler){
        super(authenticationManager);

        setFilterProcessesUrl("/auth/login");
        setAuthenticationSuccessHandler(loginSuccessHandler);
        setAuthenticationFailureHandler(failureHandler);

    }

    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) {
        LoginRequest loginRequest = LoginRequest.of(request);
        UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(loginRequest.getEmail(), loginRequest.getPassword());
        return getAuthenticationManager().authenticate(token);
    }


}

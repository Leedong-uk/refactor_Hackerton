package hackerton.refactor.general.security.handler;

import hackerton.refactor.general.enums.BadStatusCode;
import hackerton.refactor.general.exception.UnAuthorizedException;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class LoginFailureHandler implements AuthenticationFailureHandler {
    @Override
    public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response, AuthenticationException exception) throws IOException, ServletException {
        throw new UnAuthorizedException(BadStatusCode.LOGIN_FAILURE_EXCEPTION);
    }
}

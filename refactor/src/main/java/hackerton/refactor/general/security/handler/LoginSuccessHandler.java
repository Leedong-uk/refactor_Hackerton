package hackerton.refactor.general.security.handler;

import com.fasterxml.jackson.databind.ObjectMapper;
import hackerton.refactor.general.response.ApiResponse;
import hackerton.refactor.general.security.JwtService;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@Component
@RequiredArgsConstructor
public class LoginSuccessHandler implements AuthenticationSuccessHandler {
    private final JwtService jwtService;
    private final ObjectMapper objectMapper;


    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
        UserDetails user =(UserDetails)authentication.getPrincipal();

        String accessToken = jwtService.createAccessToken(user.getUsername());
        String refreshToken = jwtService.createRefreshToken(user.getUsername());

        Map<String, String> data = new HashMap<>();
        data.put("accessToken", accessToken);
        data.put("refreshToken", refreshToken);

        ApiResponse<Map<String, String>> result = ApiResponse.success(HttpStatus.OK.value(), "로그인에 성공 했습니다", data);

        response.setContentType("application/json");
        response.setStatus(HttpServletResponse.SC_OK);
        response.setCharacterEncoding("UTF-8");
        objectMapper.writeValue(response.getWriter(),result);
    }
}

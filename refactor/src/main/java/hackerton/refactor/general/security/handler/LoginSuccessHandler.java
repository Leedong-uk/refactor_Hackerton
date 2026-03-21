package hackerton.refactor.general.security.handler;

import com.fasterxml.jackson.databind.ObjectMapper;
import hackerton.refactor.general.response.ApiResponse;
import hackerton.refactor.general.security.JwtService;
import hackerton.refactor.general.security.userdetail.CustomUser;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.context.MessageSource;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.time.Duration;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

@Component
@RequiredArgsConstructor
public class LoginSuccessHandler implements AuthenticationSuccessHandler {
    private final JwtService jwtService;
    private final ObjectMapper objectMapper;
    private final MessageSource messageSource;
    private final StringRedisTemplate stringRedisTemplate;


    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException{
        CustomUser user =(CustomUser) authentication.getPrincipal();

        String accessToken = jwtService.createAccessToken(user);
        String refreshToken = jwtService.createRefreshToken(user);

        Map<String, String> data = new HashMap<>();
        data.put("accessToken", accessToken);
        data.put("refreshToken", refreshToken);

        String refreshTokenKey = "refreshToken:" + user.getMemberId();
        stringRedisTemplate.opsForValue().set(refreshTokenKey, refreshToken, Duration.ofMinutes(10));

        ApiResponse<Map<String, String>> result = ApiResponse.success(HttpStatus.OK.value(), messageSource.getMessage("user.login", null, Locale.getDefault()), data);

        response.setContentType("application/json");
        response.setStatus(HttpServletResponse.SC_OK);
        response.setCharacterEncoding("UTF-8");
        objectMapper.writeValue(response.getWriter(),result);

    }
}

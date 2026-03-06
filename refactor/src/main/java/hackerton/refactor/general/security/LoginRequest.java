package hackerton.refactor.general.security;

import com.fasterxml.jackson.databind.ObjectMapper;
import hackerton.refactor.general.security.exception.LoginFailureException;
import jakarta.servlet.http.HttpServletRequest;
import lombok.Data;

@Data
public class LoginRequest {
    public String email;
    private String password;

    public static LoginRequest of (HttpServletRequest request) {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            return objectMapper.readValue(request.getInputStream(), LoginRequest.class);
        } catch (Exception e) {
            throw new LoginFailureException("Dto 변환에 실패해 로그인에 실패했습니다");
        }
    }

}

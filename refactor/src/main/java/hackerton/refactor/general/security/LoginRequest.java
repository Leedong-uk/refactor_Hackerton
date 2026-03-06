package hackerton.refactor.general.security;

import com.fasterxml.jackson.databind.ObjectMapper;
import hackerton.refactor.general.enums.BadStatusCode;
import hackerton.refactor.general.exception.ServerErrorException;
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
            throw new ServerErrorException(BadStatusCode.FAIL_TO_CONVERT_DTO);
        }
    }

}

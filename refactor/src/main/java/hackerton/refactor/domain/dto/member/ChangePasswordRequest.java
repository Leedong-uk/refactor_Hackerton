package hackerton.refactor.domain.dto.member;

import lombok.Data;

@Data
public class ChangePasswordRequest {
    private String newPassword;
}

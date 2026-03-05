package hackerton.refactor.domain.dto;

import lombok.Data;

@Data

public class SignUpRequestDto {
    private String email;
    private String password;
    private String name;
    private String kakaoId;
    private String profileImageKey;

    public SignUpRequestDto(String email, String password, String name, String kakaoId, String profileImageKey) {
        this.email = email;
        this.password = password;
        this.name = name;
        this.kakaoId = kakaoId;
        this.profileImageKey = profileImageKey;
    }
}

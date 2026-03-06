package hackerton.refactor.general.security.userdetail;

import hackerton.refactor.domain.entity.member.Auth;
import hackerton.refactor.domain.entity.member.Member;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class CustomUserRequest {
    private Long memberId;
    private String name;
    private String email;
    private String password;
    private List<Auth> auths = new ArrayList<>();


    public static CustomUserRequest of(Member member) {
        CustomUserRequest dto = new CustomUserRequest();
        dto.memberId = member.getId();
        dto.name = member.getName();
        dto.email = member.getEmail();
        dto.password = member.getPassword();
        dto.auths = new ArrayList<>(member.getAuths());
        return dto;
    }
}

package hackerton.refactor.general.security.userdetail;

import hackerton.refactor.domain.entity.auth.AuthStatus;
import hackerton.refactor.domain.entity.member.Member;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;


@Data
// 쿼리 결과를 담을 dto
public class LoginMemberDto {
    private Long memberId;
    private String memberName;
    private String email;
    private String password;
    private List<AuthStatus> authStatuses;


    public static LoginMemberDto of (Member member , List<AuthStatus> findAuthList) {
        LoginMemberDto dto = new LoginMemberDto();
        dto.setMemberId(member.getId());
        dto.setMemberName(member.getName());
        dto.setEmail(member.getEmail());
        dto.setPassword(member.getPassword());
        dto.authStatuses = new ArrayList<>(findAuthList);
        return dto;
    }
}

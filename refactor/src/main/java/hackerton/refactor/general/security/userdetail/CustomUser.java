package hackerton.refactor.general.security.userdetail;

import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;

import java.util.stream.Collectors;

@Getter @Setter
public class CustomUser extends User {
    private Long memberId;
    private String name;
    private String email;

    public CustomUser(LoginMemberDto dto) {
        super(
                dto.getEmail(),
                dto.getPassword(),
                dto.getAuthStatuses().stream()
                        .map(auth -> new SimpleGrantedAuthority("ROLE_" + auth.name()))
                        .collect(Collectors.toList())
        );

        this.memberId = dto.getMemberId();
        this.name = dto.getMemberName();
        this.email = dto.getEmail();
    }
}

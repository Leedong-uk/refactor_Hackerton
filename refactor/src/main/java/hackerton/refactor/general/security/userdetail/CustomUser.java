package hackerton.refactor.general.security.userdetail;

import hackerton.refactor.domain.entity.auth.AuthStatus;
import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Getter @Setter
public class CustomUser extends User {
    private Long memberId;
    private String name;
    private String email;
    private List<AuthStatus> authStatuses;

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
        this.authStatuses = new ArrayList<>(dto.getAuthStatuses());
    }

    public CustomUser(Long memberId, String email, List<SimpleGrantedAuthority> authorities) {
        super(email, "", authorities);
        this.memberId = memberId;
        this.email = email;
        this.name = null;
        this.authStatuses = new ArrayList<>();
    }
}

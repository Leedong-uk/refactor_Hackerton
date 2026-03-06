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

    public CustomUser(CustomUserRequest dto) {
        super(dto.getEmail(),
                dto.getPassword(),
                dto.getAuths().stream()
                        .map(auth -> new SimpleGrantedAuthority("ROLE_" + auth.getStatus().name()))
                        .collect(Collectors.toList())
        );

        this.memberId = dto.getMemberId();
        this.name = dto.getName();
        this.email = dto.getEmail();

    }

}

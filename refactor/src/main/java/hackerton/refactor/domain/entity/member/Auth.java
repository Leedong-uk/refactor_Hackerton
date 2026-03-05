package hackerton.refactor.domain.entity.member;

import hackerton.refactor.domain.entity.base.BaseTimeEntity;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter @Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Auth extends BaseTimeEntity {

    @Id
    @GeneratedValue
    @Column(name = "auth_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id",nullable = false)
    private Member member;

    @Enumerated(EnumType.STRING)
    private AuthStatus auth;


    public Auth(Member member, AuthStatus auth) {
        this.member = member;
        this.auth = auth;
    }
}

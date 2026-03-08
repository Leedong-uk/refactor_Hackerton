package hackerton.refactor.domain.entity.member;

import hackerton.refactor.domain.dto.member.SignUpRequestDto;
import hackerton.refactor.domain.entity.base.BaseEntity;
import hackerton.refactor.domain.entity.MemberStatus;
import hackerton.refactor.domain.entity.business.Business;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter @Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Member extends BaseEntity {
    @Id
    @GeneratedValue
    @Column(name = "member_id")
    private Long id;
    private String email;
    private String password;
    private String name;
    private String kakaoId;

    @Enumerated(EnumType.STRING)
    private MemberStatus status;

    private int helpCount;

    @Enumerated(EnumType.STRING)
    private MemberBadge badge;

    private String fcmToken;


    @OneToOne(mappedBy = "member", cascade = CascadeType.ALL, orphanRemoval = true)
    private ProfileImage profileImage;

    @OneToMany(mappedBy = "member", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Auth> auths = new ArrayList<>();

    @OneToOne(mappedBy = "member", cascade = CascadeType.ALL, orphanRemoval = true)
    private Business business;



    // 편의 메서드 //
    public static Member of(SignUpRequestDto dto) {
        Member member = new Member();
        member.email = dto.getEmail();
        member.name = dto.getName();
        member.kakaoId = dto.getKakaoId();
        member.status = MemberStatus.ACTIVE;
        member.helpCount = 0;
        member.badge = MemberBadge.도움일꾼;
        member.fcmToken = "";
        return member;
    }


}

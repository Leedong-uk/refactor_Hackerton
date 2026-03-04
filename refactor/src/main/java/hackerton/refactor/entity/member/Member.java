package hackerton.refactor.entity.member;

import hackerton.refactor.entity.base.BaseEntity;
import hackerton.refactor.entity.MemberStatus;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter @Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@ToString(of={"id,email,name,kakao_id","status","helpCount","badge"})
public class Member extends BaseEntity {
    @Id
    @GeneratedValue
    @Column(name = "member_id")
    private Long id;
    private String email;
    private String name;
    private String kakao_id;

    @Enumerated(EnumType.STRING)
    private MemberStatus status;
    private int helpCount;
    private String badge;



}

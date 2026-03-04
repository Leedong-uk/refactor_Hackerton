package hackerton.refactor.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter @Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@ToString(of={"id,email,name,kakao_id"})
public class Member extends BaseEntity{
    @Id
    @GeneratedValue
    private Long id;
    private String email;
    private String name;
    private String kakao_id;

    @Enumerated(EnumType.STRING)
    private MemberStatus status;

    private int helpCount;
    private String badge;

}

package hackerton.refactor.entity.member;

import hackerton.refactor.entity.BaseEntity;
import hackerton.refactor.entity.MemberStatus;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

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

    @OneToMany(mappedBy = "member",cascade = CascadeType.ALL,orphanRemoval = true)
    List<ProfileImage> profiles = new ArrayList<>();

    private int helpCount;
    private String badge;

    public void addProfile(ProfileImage profile) {
        profiles.add(profile);
        profile.setMember(this);
    }

}

package hackerton.refactor.domain.entity.member;

import hackerton.refactor.domain.entity.base.BaseTimeEntity;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity
@Getter @Setter
public class ProfileImage extends BaseTimeEntity {
    @Id
    @GeneratedValue
    @Column(name = "profile_image_id")
    private Long id;

    @Column(nullable = false)
    private String storageKey = "";

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id",nullable = false)
    private Member member;

    public ProfileImage() {
    }

    // 생성 메서드 //
    public void addMember(Member member) {
        this.member = member;
        member.setProfileImage(this);
    }


}

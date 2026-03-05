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
public class ProfileImage extends BaseTimeEntity {
    @Id
    @GeneratedValue
    @Column(name = "profile_image_id")
    private Long id;

    @Column(nullable = false)
    private String storageKey = "";

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id",nullable = false)
    private Member member;

    // 생성 메서드 //
    public static ProfileImage of(String storageKey , Member member) {
        ProfileImage profileImage = new ProfileImage();
        profileImage.setStorageKey(storageKey);
        profileImage.setMember(member);
        return profileImage;
    }

}

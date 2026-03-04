package hackerton.refactor.entity.member;

import hackerton.refactor.entity.BaseEntity;
import jakarta.annotation.Nullable;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity
@Getter @Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class ProfileImage extends BaseEntity {
    @Id
    @GeneratedValue
    @Column(name = "profile_image_id")
    private Long id;

    @Column(nullable = false)
    private String storageKey = "";

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member member;


}

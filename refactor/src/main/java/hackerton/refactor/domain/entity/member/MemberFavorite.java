package hackerton.refactor.domain.entity.member;

import hackerton.refactor.domain.entity.announce.Announce;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter @Setter
@Table(uniqueConstraints = @UniqueConstraint(columnNames = {"member_id","announce_id"}))
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class MemberFavorite {
    @Id
    @GeneratedValue
    @Column(name = "member_favorite_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "announce_id")
    private Announce announce;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member member;

}

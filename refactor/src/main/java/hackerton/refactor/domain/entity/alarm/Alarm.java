package hackerton.refactor.domain.entity.alarm;

import hackerton.refactor.domain.entity.base.BaseEntity;
import hackerton.refactor.domain.entity.member.Member;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter @Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Alarm extends BaseEntity {
    @Id
    @GeneratedValue
    @Column(name = "alarm_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id", nullable = false)
    private Member member;

    @Lob
    private String content;

    @Enumerated(EnumType.STRING)
    private AlarmType type;

    @Column(nullable = false)
    private boolean isRead=false;

}

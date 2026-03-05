package hackerton.refactor.entity.sos;

import hackerton.refactor.entity.base.BaseEntity;
import hackerton.refactor.entity.member.Member;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Getter @Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Sos extends BaseEntity {
    @Id
    @GeneratedValue
    @Column(name = "sos_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id",nullable = false)
    private Member member;

    private String title;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private SosType type;

    @Lob
    private String content;
    private LocalDateTime expiredAt;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private SosStatus status = SosStatus.ACTIVE;
}

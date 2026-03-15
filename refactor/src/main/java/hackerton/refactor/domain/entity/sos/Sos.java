package hackerton.refactor.domain.entity.sos;

import hackerton.refactor.domain.dto.SosCreateRequest;
import hackerton.refactor.domain.entity.base.BaseEntity;
import hackerton.refactor.domain.entity.member.Member;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Getter @Setter
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

    public Sos() {
    }

    // 생성 메서드 //
    public static Sos of (SosCreateRequest request) {
        Sos sos = new Sos();
        sos.setTitle(request.getTitle());
        sos.setType(request.getType());
        sos.setContent(request.getContent());
        sos.setExpiredAt(request.getExpiredAt());
        return sos;
    }
}

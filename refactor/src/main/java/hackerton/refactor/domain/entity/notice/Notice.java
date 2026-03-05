package hackerton.refactor.domain.entity.notice;

import hackerton.refactor.domain.entity.base.BaseEntity;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter @Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Notice extends BaseEntity {
    @Id
    @GeneratedValue
    @Column(name = "notice_id")
    private Long id;
    private String title;

    @Lob
    private String content;

    @Enumerated(EnumType.STRING)
    private NoticeStatus status;


}

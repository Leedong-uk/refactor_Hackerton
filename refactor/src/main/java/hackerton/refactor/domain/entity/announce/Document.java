package hackerton.refactor.domain.entity.announce;

import hackerton.refactor.domain.entity.base.BaseEntity;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter @Setter
public class Document extends BaseEntity {
    @Id
    @GeneratedValue
    @Column(name = "document_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "announce_id",nullable = false)
    private Announce announce;
    private String title;
    @Lob
    private String description;

    public Document() {
    }
}

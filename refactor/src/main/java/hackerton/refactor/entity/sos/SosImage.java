package hackerton.refactor.entity.sos;

import hackerton.refactor.entity.base.BaseEntity;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter @Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class SosImage extends BaseEntity {
    @Id
    @GeneratedValue
    @Column(name = "sos_image_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "sos_id",nullable = false)
    private Sos sos;

    @Column(nullable = false)
    private String storageKey;

    private int sortOrder;
}

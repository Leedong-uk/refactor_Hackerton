package hackerton.refactor.domain.entity;

import hackerton.refactor.domain.entity.base.BaseEntity;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter @Setter
public class Article extends BaseEntity {
    @Id
    @GeneratedValue
    @Column(name = "article_id")
    private Long id;
    private String title;
    @Lob
    private String content;
    private String author;
    @Column(length = 500)
    private String url;

    public Article() {
    }
}

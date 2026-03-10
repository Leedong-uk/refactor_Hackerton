package hackerton.refactor.domain.repository.article;

import hackerton.refactor.domain.entity.Article;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ArticleRepository extends JpaRepository<Article,Long> {
    Slice<Article> findAllBy(Pageable pageable);
}

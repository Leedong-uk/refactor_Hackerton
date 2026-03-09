package hackerton.refactor.domain.repository.article;

import hackerton.refactor.domain.entity.Article;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ArticleRepository extends JpaRepository<Article,Long> {
}

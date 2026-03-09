package hackerton.refactor.domain.dto.article;

import hackerton.refactor.domain.entity.Article;
import lombok.Data;

import java.util.List;

@Data
public class ArticleListResponse {
    private List<Article> articles;
}

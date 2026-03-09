package hackerton.refactor.web.controller.article;

import hackerton.refactor.domain.dto.article.ArticleListResponse;
import hackerton.refactor.domain.service.ArticleService;
import hackerton.refactor.general.response.ApiSuccess;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class ArticleController {
    private final ArticleService articleService;

    @GetMapping("/articles/list")
    @ApiSuccess(message = "article.list")
    public ArticleListResponse getArticles(Pageable pageable) {
        return articleService.getArticles(pageable);
    }
}

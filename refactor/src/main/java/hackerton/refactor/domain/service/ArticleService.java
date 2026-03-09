package hackerton.refactor.domain.service;

import hackerton.refactor.domain.dto.article.ArticleListResponse;
import hackerton.refactor.domain.entity.Article;
import hackerton.refactor.domain.repository.article.ArticleRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;


@Service
@Slf4j
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class ArticleService {
    private final ArticleRepository articleRepository;

    public ArticleListResponse getArticles(Pageable pageable) {

        Page<Article> page = articleRepository.findAll(pageable);

        ArticleListResponse result = new ArticleListResponse();
        result.setArticles(new ArrayList<>(page.getContent()));
        return result;
    }
}

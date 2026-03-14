package hackerton.refactor.general.init;


import hackerton.refactor.domain.entity.Article;
import hackerton.refactor.domain.entity.business.BusinessCode;
import hackerton.refactor.domain.repository.article.ArticleRepository;
import hackerton.refactor.domain.repository.business.BusinessCodeRepository;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Configuration
@RequiredArgsConstructor
@Profile("init")
public class SampleData {
    private final InitService initService;

    @PostConstruct
    public void init() {
        initService.initBusinessCode();
        initService.initArticle();
        initService.initAnnounce();
        initService.initFestival();
        initService.initNotice();

    }

}

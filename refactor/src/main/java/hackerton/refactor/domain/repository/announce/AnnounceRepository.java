package hackerton.refactor.domain.repository.announce;

import hackerton.refactor.domain.entity.Article;
import hackerton.refactor.domain.entity.announce.Announce;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AnnounceRepository extends JpaRepository<Announce,Long> {
    Slice<Announce> findAllBy(Pageable pageable);
}

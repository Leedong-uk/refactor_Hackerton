package hackerton.refactor.domain.repository.festival;

import hackerton.refactor.domain.entity.festival.Festival;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FestivalRepository extends JpaRepository<Festival,Long> {
    Festival findFestivalById(Long id);

    Slice<Festival> findAllBy(Pageable pageable);
}

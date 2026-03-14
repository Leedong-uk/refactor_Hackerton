package hackerton.refactor.domain.repository.favorite;

import hackerton.refactor.domain.dto.favorite.FavoriteResponse;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;


public interface FavoriteQueryRepository {
    Slice<FavoriteResponse> findFavoritesByMemberId(Long memberId, Pageable pageable);

}
package hackerton.refactor.domain.repository.announce;

import hackerton.refactor.domain.dto.announce.AnnounceDetailResponse;
import hackerton.refactor.domain.dto.announce.AnnounceResponse;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;

public interface AnnounceQueryRepository {
    Slice<AnnounceResponse> findAnnounceWithFavorite(Long memberId,Pageable pageable);


}

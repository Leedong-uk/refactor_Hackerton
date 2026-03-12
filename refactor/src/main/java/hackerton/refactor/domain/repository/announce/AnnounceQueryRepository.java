package hackerton.refactor.domain.repository.announce;

import hackerton.refactor.domain.dto.announce.AnnounceResponse;
import hackerton.refactor.domain.entity.announce.Announce;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;

public interface AnnounceQueryRepository {
    Slice<AnnounceResponse> findAnnounceWithFavorite(Long memberId,Pageable pageable);

    Long updateViewNum(Long announceId);

//    Announce findAnnounceWithDocuments(Long announceId);


}

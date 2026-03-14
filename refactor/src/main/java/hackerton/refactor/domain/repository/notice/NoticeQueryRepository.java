package hackerton.refactor.domain.repository.notice;

import hackerton.refactor.domain.dto.notice.NoticeDetailResponse;
import hackerton.refactor.domain.dto.notice.NoticeResponse;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;

import java.util.List;

public interface NoticeQueryRepository {
    Slice<NoticeResponse> getAllNotice(Pageable pageable);

    NoticeDetailResponse getNoticeDetailById(Long noticeId);
}

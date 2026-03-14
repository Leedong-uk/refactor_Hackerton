package hackerton.refactor.domain.service;

import hackerton.refactor.domain.dto.notice.NoticeDetailResponse;
import hackerton.refactor.domain.dto.notice.NoticeResponse;
import hackerton.refactor.domain.entity.notice.Notice;
import hackerton.refactor.domain.repository.notice.NoticeRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
@Slf4j
public class NoticeService {
    private final NoticeRepository noticeRepository;

    public List<NoticeResponse> getAllNotice(Pageable pageable) {
         return noticeRepository.getAllNotice(pageable).getContent();
    }

    public NoticeDetailResponse getNoticeDetail (Long noticeId) {
        return noticeRepository.getNoticeDetailById(noticeId);
    }
}

package hackerton.refactor.web.controller.notice;

import hackerton.refactor.domain.dto.notice.NoticeDetailResponse;
import hackerton.refactor.domain.dto.notice.NoticeResponse;
import hackerton.refactor.domain.service.NoticeService;
import hackerton.refactor.general.response.ApiSuccess;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class NoticeController {
    private final NoticeService noticeService;

    @GetMapping("/notice")
    @ApiSuccess(message = "notice.list")
    public List<NoticeResponse> getAllNotices(Pageable pageable) {
        return noticeService.getAllNotice(pageable);
    }

    @GetMapping("/notice/{notice_id}")
    @ApiSuccess(message = "notice.detail")
    NoticeDetailResponse getNoticeById(@PathVariable("notice_id") Long noticeId) {
        return noticeService.getNoticeDetail(noticeId);
    }

}

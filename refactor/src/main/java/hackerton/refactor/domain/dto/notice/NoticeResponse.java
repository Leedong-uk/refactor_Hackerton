package hackerton.refactor.domain.dto.notice;

import lombok.Data;

@Data
public class NoticeResponse {
    private Long noticeId;
    private String title;

    public NoticeResponse(Long noticeId, String title) {
        this.noticeId = noticeId;
        this.title = title;
    }
}

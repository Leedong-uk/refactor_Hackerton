package hackerton.refactor.domain.dto.notice;

import lombok.Data;

import java.util.Date;

@Data
public class NoticeDetailResponse {
    private Long noticeId;
    private String title;
    private String content;

    public NoticeDetailResponse(Long noticeId, String title, String content) {
        this.noticeId = noticeId;
        this.title = title;
        this.content = content;
    }
}

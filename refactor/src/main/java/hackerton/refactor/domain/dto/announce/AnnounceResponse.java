package hackerton.refactor.domain.dto.announce;


import lombok.Data;
import java.time.LocalDateTime;

@Data
public class AnnounceResponse {

    private Long announceId;
    private String title;
    private String excInsttNm;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
    private LocalDateTime pubDate;
    private Boolean isFavorite;
    private String lcategory;

    public AnnounceResponse(
            Long announceId,
            String title,
            String excInsttNm,
            LocalDateTime startDate,
            LocalDateTime endDate,
            LocalDateTime pubDate,
            Boolean isFavorite,
            String lcategory
    ) {
        this.announceId = announceId;
        this.title = title;
        this.excInsttNm = excInsttNm;
        this.startDate = startDate;
        this.endDate = endDate;
        this.pubDate = pubDate;
        this.isFavorite = isFavorite;
        this.lcategory = lcategory;
    }
}

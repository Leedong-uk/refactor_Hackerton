package hackerton.refactor.domain.dto.festival;

import hackerton.refactor.domain.entity.festival.Festival;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@Builder
public class FestivalDetailResponse {
    private String festivalTitle;
    private String addr;
    private double mapX;
    private double mapY;
    private LocalDate eventStartDate;
    private LocalDate eventEndDate;
    private String firstImage;
    private String tel;
    private String overView;
    private String telName;

    public static FestivalDetailResponse of(Festival festival) {
        return FestivalDetailResponse.builder()
                .festivalTitle(festival.getTitle())
                .addr(festival.getAddress() + " " + festival.getDetailAddress())
                .mapX(festival.getMapX())
                .mapY(festival.getMapY())
                .eventStartDate(festival.getEventStartDate())
                .eventEndDate(festival.getEventEndDate())
                .firstImage(festival.getFirstImage())
                .tel(festival.getTel())
                .overView(festival.getOverview())
                .telName(festival.getTelName())
                .build();

    }
}

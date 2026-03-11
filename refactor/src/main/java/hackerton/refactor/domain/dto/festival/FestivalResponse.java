package hackerton.refactor.domain.dto.festival;

import hackerton.refactor.domain.entity.festival.Festival;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@Builder
public class FestivalResponse {
    private Long festivalId;
    private String festivalTitle;
    private String addr;
    private LocalDate eventStartDate;
    private LocalDate eventEndDate;
    private String firstImage;

    public static FestivalResponse of(Festival festival) {
        return FestivalResponse.builder()
                .festivalId(festival.getId())
                .festivalTitle(festival.getTitle())
                .addr(festival.getAddress() + " " + festival.getDetailAddress())
                .eventStartDate(festival.getEventStartDate())
                .eventEndDate(festival.getEventEndDate())
                .firstImage(festival.getFirstImage())
                .build();
    }
}

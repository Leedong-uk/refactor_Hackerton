package hackerton.refactor.domain.dto.favorite;

import hackerton.refactor.domain.entity.member.MemberFavorite;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
@AllArgsConstructor
public class FavoriteResponse {
    private Long announceId;
    private String announceTitle;
    private LocalDateTime deadline;   // announce.reqst_end_date
    private int totalDocs;
    private int checkedDocs;

}

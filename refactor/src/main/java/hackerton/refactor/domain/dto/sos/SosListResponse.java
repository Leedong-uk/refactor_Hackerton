package hackerton.refactor.domain.dto.sos;

import hackerton.refactor.domain.entity.sos.SosType;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
public class SosListResponse {
    private String businessName;
    private String businessAddr;
    private String businessAddrDetail;
    private Long sosId;
    private String sosTitle;
    private SosType sosType;
    private LocalDateTime createdAt;
    private LocalDateTime expiredAt;
    private Long memberId;
    private String profileImage;


}

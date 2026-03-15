package hackerton.refactor.domain.dto;


import hackerton.refactor.domain.entity.sos.SosType;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
@AllArgsConstructor
public class SosCreateRequest {
    private String title;
    private SosType type;
    private String content;
    private LocalDateTime expiredAt;
    private List<String> images;
}

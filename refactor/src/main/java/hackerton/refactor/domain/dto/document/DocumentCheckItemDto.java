package hackerton.refactor.domain.dto.document;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class DocumentCheckItemDto {
    private Long documentId;
    private String title;
    private boolean checked;

}

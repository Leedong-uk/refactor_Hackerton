package hackerton.refactor.domain.dto.document;

import lombok.Data;

@Data
public class DocumentCheckItemDto {
    private Long documentId;
    private boolean checked;
}

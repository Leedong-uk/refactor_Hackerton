package hackerton.refactor.domain.dto.document;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class DocumentInsertRequest {
    private Long documentId;
    private boolean checked;
}

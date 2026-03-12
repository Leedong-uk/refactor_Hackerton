package hackerton.refactor.domain.dto.document;

import hackerton.refactor.domain.entity.announce.Document;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class DocumentItemDto {
    private Long documentId;
    private String title;
    private String description;
    private Boolean checked;

    public static DocumentItemDto of(Document document) {
        return DocumentItemDto.builder()
                .documentId(document.getId())
                .title(document.getTitle())
                .description(document.getDescription())
                .build();
    }


}

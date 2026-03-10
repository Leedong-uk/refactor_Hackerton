package hackerton.refactor.domain.dto.document;

import hackerton.refactor.domain.entity.announce.Document;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class DocumentItemDto {
    private Long documentId;
    private String title;
    private String description;

    public static DocumentItemDto of(Document document) {
        return DocumentItemDto.builder()
                .documentId(document.getId())
                .title(document.getTitle())
                .description(document.getDescription())
                .build();
    }


}

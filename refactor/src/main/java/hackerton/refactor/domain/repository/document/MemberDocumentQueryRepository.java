package hackerton.refactor.domain.repository.document;

import hackerton.refactor.domain.dto.document.DocumentCheckItemDto;

import java.util.List;

public interface MemberDocumentQueryRepository {
    List<DocumentCheckItemDto> findChecklist(Long memberId, Long announceId);
}

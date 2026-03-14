package hackerton.refactor.domain.service;

import hackerton.refactor.domain.dto.document.DocumentCheckItemDto;
import hackerton.refactor.domain.repository.document.MemberDocumentCheckRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RequiredArgsConstructor
@Service
@Transactional(readOnly = true)
@Slf4j
public class MemberDocumentCheckService {
    private final MemberDocumentCheckRepository memberDocumentCheckRepository;

    //멤버별로 공고 제출 서류 check 여부 포함
    public List<DocumentCheckItemDto> getAllChecklist(Long memberId, Long announceId) {
        return memberDocumentCheckRepository.findChecklist(memberId, announceId);
    }
}

package hackerton.refactor.domain.service;

import hackerton.refactor.domain.dto.document.DocumentCheckItemDto;
import hackerton.refactor.domain.dto.document.DocumentInsertRequest;
import hackerton.refactor.domain.entity.document.Document;
import hackerton.refactor.domain.entity.document.MemberDocumentCheck;
import hackerton.refactor.domain.entity.member.Member;
import hackerton.refactor.domain.repository.document.MemberDocumentCheckRepository;
import hackerton.refactor.general.enums.BadStatusCode;
import hackerton.refactor.general.exception.ServerErrorException;
import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
@Transactional(readOnly = true)
@Slf4j
public class MemberDocumentCheckService {
    private final MemberDocumentCheckRepository memberDocumentCheckRepository;
    private final EntityManager em;

    //멤버별로 공고 제출 서류 check 여부 포함
    public List<DocumentCheckItemDto> getAllChecklist(Long memberId, Long announceId) {
        return memberDocumentCheckRepository.findChecklist(memberId, announceId);
    }

    @Transactional
    public void saveChecklist(Long memberId, Long announceId, List<DocumentInsertRequest> requests) {

        if (requests == null || requests.isEmpty()) return;

        //  기존 전체 삭제 (쿼리 1번)
        memberDocumentCheckRepository.deleteChecklist(memberId, announceId);

        Member memberProxy = em.getReference(Member.class, memberId);
        List<MemberDocumentCheck> inserts = new ArrayList<>();

        for (DocumentInsertRequest req : requests) {
            // checked = true 인 것만 저장
            if (!req.isChecked()) continue;

            MemberDocumentCheck check = new MemberDocumentCheck();
            check.setMember(memberProxy);
            check.setDocument(em.getReference(Document.class, req.getDocumentId()));
            check.setChecked(true);

            inserts.add(check);
        }

        if (!inserts.isEmpty()) {
            memberDocumentCheckRepository.saveAll(inserts);
        }
    }
}

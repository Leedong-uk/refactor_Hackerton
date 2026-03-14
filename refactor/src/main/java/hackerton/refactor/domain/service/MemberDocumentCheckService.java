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
    public void saveChecklist(Long memberId, List<DocumentInsertRequest> requests) {
        log.info("memberId = {}", memberId);
        requests.forEach(r -> log.info("docId = {}", r.getDocumentId()));

        if(requests == null || requests.isEmpty())
            throw new ServerErrorException(BadStatusCode.INTERNAL_SERVER_EXCEPTION);

        List<Long> docIds =requests.stream()
                .map(DocumentInsertRequest::getDocumentId)
                .toList();

        //  (쿼리 1번)
        List<MemberDocumentCheck> existing = memberDocumentCheckRepository.findAllByMemberIdAndDocumentIdIn(memberId, docIds);

        Map<Long, MemberDocumentCheck> map = existing.stream()
                .collect(Collectors.toMap(c ->
                                c.getDocument().getId(),
                        c -> c));

        List<MemberDocumentCheck> toInsert = new ArrayList<>();
        for (DocumentInsertRequest request : requests) {

            Long documentId = request.getDocumentId();
            MemberDocumentCheck existingCheck = map.get(documentId);

            //  존재하지 않는 경우 → INSERT 대상
            if (existingCheck == null) {

                // 새로운 엔티티 생성
                MemberDocumentCheck newCheck = new MemberDocumentCheck();
                Member memberProxy = em.getReference(Member.class, memberId);
                Document documentProxy = em.getReference(Document.class, documentId);
                newCheck.setMember(memberProxy);
                newCheck.setDocument(documentProxy);
                newCheck.setChecked(request.isChecked());

                // 나중에 한번에 saveAll 하기 위해 리스트에 담음
                toInsert.add(newCheck);

            }
            else {
                existingCheck.setChecked(request.isChecked());
            }
        }
        log.info("toInsert size = {}", toInsert.size());
        memberDocumentCheckRepository.saveAll(toInsert);
    }
}

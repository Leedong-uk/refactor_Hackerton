package hackerton.refactor.domain.repository.document;

import hackerton.refactor.domain.entity.document.MemberDocumentCheck;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MemberDocumentCheckRepository extends JpaRepository<MemberDocumentCheck,Long> , MemberDocumentQueryRepository {
    List<MemberDocumentCheck> findAllByMemberIdAndDocumentIdIn(Long memberId, List<Long> documentIds);
}

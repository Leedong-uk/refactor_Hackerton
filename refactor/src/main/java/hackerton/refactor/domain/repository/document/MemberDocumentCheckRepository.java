package hackerton.refactor.domain.repository.document;

import hackerton.refactor.domain.entity.document.MemberDocumentCheck;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberDocumentCheckRepository extends JpaRepository<MemberDocumentCheck,Long> , MemberDocumentQueryRepository {
}

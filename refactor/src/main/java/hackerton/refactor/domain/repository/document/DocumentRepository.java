package hackerton.refactor.domain.repository.document;

import hackerton.refactor.domain.entity.document.Document;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DocumentRepository extends JpaRepository<Document,Long> {
}

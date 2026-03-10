package hackerton.refactor.domain.repository.announce;

import hackerton.refactor.domain.entity.announce.Document;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DocumentRepository extends JpaRepository<Document,Long> {
    List<Document> findDocumentByAnnounce_Id(Long announceId);
}

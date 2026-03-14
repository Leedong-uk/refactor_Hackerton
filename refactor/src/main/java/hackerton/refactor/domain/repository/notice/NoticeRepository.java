package hackerton.refactor.domain.repository.notice;

import hackerton.refactor.domain.entity.notice.Notice;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NoticeRepository extends JpaRepository<Notice,Long>,NoticeQueryRepository{
}

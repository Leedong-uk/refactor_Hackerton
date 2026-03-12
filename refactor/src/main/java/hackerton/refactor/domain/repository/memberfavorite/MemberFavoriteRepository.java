package hackerton.refactor.domain.repository.memberfavorite;

import hackerton.refactor.domain.entity.member.MemberFavorite;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberFavoriteRepository extends JpaRepository<MemberFavorite,Long> {
}

package hackerton.refactor.domain.repository.memberfavorite;

import hackerton.refactor.domain.entity.member.MemberFavorite;
import org.springframework.data.jpa.repository.JpaRepository;

//사용자가 즐겨찾기한 공고
public interface MemberFavoriteRepository extends JpaRepository<MemberFavorite,Long> {
}

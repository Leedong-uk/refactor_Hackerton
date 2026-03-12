package hackerton.refactor.domain.repository.favorite;

import hackerton.refactor.domain.entity.member.MemberFavorite;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FavoriteRepository extends JpaRepository<MemberFavorite,Long> {
}

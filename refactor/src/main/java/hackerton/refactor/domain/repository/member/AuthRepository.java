package hackerton.refactor.domain.repository.member;

import hackerton.refactor.domain.entity.member.Auth;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthRepository extends JpaRepository<Auth,Long> {
}

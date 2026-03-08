package hackerton.refactor.domain.repository.auth;

import hackerton.refactor.domain.entity.auth.Auth;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthRepository extends JpaRepository<Auth, Long>, AuthQueryRepository {
    void removeByMemberId(Long id);
}

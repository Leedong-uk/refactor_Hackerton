package hackerton.refactor.domain.repository;

import hackerton.refactor.domain.entity.member.Auth;
import hackerton.refactor.domain.entity.member.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthRepository extends JpaRepository<Auth,Long> {
}

package hackerton.refactor.domain.repository;

import hackerton.refactor.domain.entity.member.Member;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MemberRepository extends JpaRepository<Member,Long> {

    Member findMemberById(Long id);
    void removeById(Long id);
}

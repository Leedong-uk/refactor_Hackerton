package hackerton.refactor.domain.repository.member;

import hackerton.refactor.domain.entity.member.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MemberRepository extends JpaRepository<Member,Long> , MemberQueryRepository {

    Member findMemberById(Long id);
    void removeById(Long id);
    Member findMemberByEmail(String email);

    Member findMemberFetchWithBusiness(Long id);
}

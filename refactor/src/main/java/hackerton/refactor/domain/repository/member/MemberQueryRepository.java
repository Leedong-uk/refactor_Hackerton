package hackerton.refactor.domain.repository.member;


import hackerton.refactor.domain.entity.member.Member;
import org.springframework.stereotype.Repository;

public interface MemberQueryRepository {
    Member findMemberFetchWithBusiness(Long id);
}

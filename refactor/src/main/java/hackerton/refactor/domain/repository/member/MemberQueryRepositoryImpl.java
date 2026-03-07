package hackerton.refactor.domain.repository.member;


import com.querydsl.jpa.impl.JPAQueryFactory;
import hackerton.refactor.domain.entity.business.QBusiness;
import hackerton.refactor.domain.entity.member.Member;
import hackerton.refactor.domain.entity.member.QMember;
import lombok.RequiredArgsConstructor;

import static hackerton.refactor.domain.entity.business.QBusiness.business;
import static hackerton.refactor.domain.entity.member.QMember.member;

@RequiredArgsConstructor
public class MemberQueryRepositoryImpl implements MemberQueryRepository{

    private final JPAQueryFactory queryFactory;

    @Override
    public Member findMemberFetchWithBusiness(Long id) {
        return queryFactory.selectFrom(member)
                .leftJoin(member.business, business).fetchJoin()
                .where(member.id.eq(id))
                .fetchOne();
    }
}

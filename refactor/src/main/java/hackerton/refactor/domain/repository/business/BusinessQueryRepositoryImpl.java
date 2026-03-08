package hackerton.refactor.domain.repository.business;

import com.querydsl.jpa.impl.JPAQueryFactory;
import hackerton.refactor.domain.entity.business.Business;
import hackerton.refactor.domain.entity.business.QBusiness;
import hackerton.refactor.domain.entity.member.QMember;
import lombok.RequiredArgsConstructor;

import static hackerton.refactor.domain.entity.business.QBusiness.business;
import static hackerton.refactor.domain.entity.member.QMember.member;

@RequiredArgsConstructor
public class BusinessQueryRepositoryImpl implements BusinessQueryRepository{

    private final JPAQueryFactory queryFactory;

    @Override
    public Business findBusinessWithMember(Long memberId) {
        return queryFactory.selectFrom(business)
                .join(business.member, member).fetchJoin()
                .where(member.id.eq(memberId))
                .fetchOne();
    }
}

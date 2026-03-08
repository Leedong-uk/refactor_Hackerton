package hackerton.refactor.domain.repository.member;


import com.querydsl.jpa.impl.JPAQueryFactory;

import hackerton.refactor.domain.entity.business.QBusiness;
import hackerton.refactor.domain.entity.business.QBusinessCode;
import hackerton.refactor.domain.entity.member.Member;
import hackerton.refactor.domain.entity.member.QMember;
import hackerton.refactor.domain.entity.member.QProfileImage;
import lombok.RequiredArgsConstructor;

import static hackerton.refactor.domain.entity.business.QBusiness.*;
import static hackerton.refactor.domain.entity.business.QBusinessCode.businessCode;
import static hackerton.refactor.domain.entity.member.QMember.member;
import static hackerton.refactor.domain.entity.member.QProfileImage.profileImage;

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

    @Override
    public Member findMemberWithBusinessAndProfileImage(Long id) {
        return queryFactory.selectFrom(member)
                .join(member.business, business).fetchJoin()
                .leftJoin(member.profileImage, profileImage).fetchJoin()
                .join(business.businessCode, businessCode).fetchJoin()
                .where(member.id.eq(id))
                .fetchOne();
    }


}

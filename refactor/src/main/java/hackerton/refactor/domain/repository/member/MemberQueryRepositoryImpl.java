package hackerton.refactor.domain.repository.member;


import com.querydsl.core.types.Projections;
import com.querydsl.jpa.impl.JPAQueryFactory;

import hackerton.refactor.domain.dto.member.MemberBusinessProfileDto;
import lombok.RequiredArgsConstructor;

import static hackerton.refactor.domain.entity.business.QBusiness.business;
import static hackerton.refactor.domain.entity.business.QBusinessCode.businessCode;
import static hackerton.refactor.domain.entity.member.QMember.member;
import static hackerton.refactor.domain.entity.member.QProfileImage.profileImage;


@RequiredArgsConstructor
public class MemberQueryRepositoryImpl implements MemberQueryRepository{

    private final JPAQueryFactory queryFactory;

    @Override
    public MemberBusinessProfileDto findMemberWithBusinessAndProfile(Long memberId) {
        return queryFactory
                .select(Projections.constructor(
                        MemberBusinessProfileDto.class,
                        member.name, member.email,
                        business.name, business.businessNumber,
                        business.businessOpenDate, business.businessAddr,
                        business.businessAddrDetail, business.businessCode.minorName,
                        member.badge ,profileImage.storageKey

                ))
                .from(member)
                .leftJoin(business).on(business.member.eq(member))
                .leftJoin(business.businessCode, businessCode)
                .leftJoin(profileImage).on(profileImage.member.eq(member))
                .where(member.id.eq(memberId))
                .fetchOne();
    }
}

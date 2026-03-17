package hackerton.refactor.domain.repository.sos;

import com.querydsl.core.types.Projections;
import com.querydsl.jpa.impl.JPAQueryFactory;
import hackerton.refactor.domain.dto.sos.SosDetailResponse;
import hackerton.refactor.domain.dto.sos.SosListResponse;
import lombok.RequiredArgsConstructor;

import java.util.List;

import static hackerton.refactor.domain.entity.business.QBusiness.business;
import static hackerton.refactor.domain.entity.business.QBusinessCode.businessCode;
import static hackerton.refactor.domain.entity.member.QMember.member;
import static hackerton.refactor.domain.entity.member.QProfileImage.profileImage;
import static hackerton.refactor.domain.entity.sos.QSos.sos;
import static hackerton.refactor.domain.entity.sos.QSosImage.sosImage;

@RequiredArgsConstructor
public class SosQueryRepositoryImpl implements SosQueryRepository{

    private final JPAQueryFactory queryFactory;

    @Override
    public List<SosListResponse> getAllSos() {
        return queryFactory
                .select(Projections.constructor(SosListResponse.class,
                        business.name,
                        business.businessAddr,
                        business.businessAddrDetail,
                        sos.id,
                        sos.title,
                        sos.type,
                        sos.createdDate,
                        sos.expiredAt,
                        member.id,
                        profileImage.storageKey
                ))
                .from(sos)
                .leftJoin(sos.member, member)
                .leftJoin(business).on(business.member.eq(member))
                .leftJoin(profileImage).on(profileImage.member.eq(member))
                .fetch();
    }

    @Override
    public SosDetailResponse getSosDetail(Long sosId) {
        SosDetailResponse base = queryFactory.select(Projections.constructor(SosDetailResponse.class,
                        member.badge,
                        profileImage.storageKey,
                        business.name,
                        business.businessAddr,
                        business.businessAddrDetail,
                        businessCode.minorName,
                        sos.id,
                        sos.title,
                        sos.type,
                        sos.content,
                        sos.expiredAt,
                        sos.createdDate))
                .from(sos)
                .leftJoin(sos.member, member)
                .leftJoin(business).on(business.member.eq(member))
                .leftJoin(profileImage).on(profileImage.member.eq(member))
                .leftJoin(business.businessCode, businessCode)
                .where(sos.id.eq(sosId))
                .fetchOne();

        List<String> imageKeys = queryFactory
                .select(sosImage.storageKey)
                .from(sosImage)
                .where(sosImage.sos.id.eq(sosId))
                .fetch();

        base.setImageKeys(imageKeys);
        return base;
    }
}

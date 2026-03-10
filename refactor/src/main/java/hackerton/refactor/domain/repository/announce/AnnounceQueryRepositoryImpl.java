package hackerton.refactor.domain.repository.announce;

import com.querydsl.core.types.Projections;
import com.querydsl.jpa.JPAExpressions;
import com.querydsl.jpa.impl.JPAQueryFactory;
import hackerton.refactor.domain.dto.announce.AnnounceDetailResponse;
import hackerton.refactor.domain.dto.announce.AnnounceResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.data.domain.SliceImpl;

import java.util.List;

import static hackerton.refactor.domain.entity.announce.QAnnounce.announce;
import static hackerton.refactor.domain.entity.member.QMemberFavorite.memberFavorite;

@RequiredArgsConstructor
public class AnnounceQueryRepositoryImpl implements AnnounceQueryRepository{

    private final JPAQueryFactory queryFactory;

    @Override
    public Slice<AnnounceResponse> findAnnounceWithFavorite(Long memberId, Pageable pageable) {

        List<AnnounceResponse> content = queryFactory
                .select(Projections.constructor(
                        AnnounceResponse.class,
                        announce.id, announce.title, announce.excInsttNm, announce.reqstStartDate, announce.reqstEndDate, announce.pubDate,
                        JPAExpressions.selectOne().from(memberFavorite)
                                .where(
                                memberFavorite.member.id.eq(memberId), memberFavorite.announce.id.eq(announce.id))
                                .exists(),
                        announce.lcategory
                ))
                .from(announce)
                .offset(pageable.getOffset())
                .limit(pageable.getPageSize() + 1)
                .fetch();

        boolean hasNext = false;
        if (content.size() > pageable.getPageSize()) {
            hasNext = true;
            content.remove(pageable.getPageSize());
        }

        return new SliceImpl<>(content, pageable, hasNext);
    }

}

package hackerton.refactor.domain.repository.favorite;

import com.querydsl.core.types.Projections;
import com.querydsl.jpa.impl.JPAQueryFactory;
import hackerton.refactor.domain.dto.favorite.FavoriteResponse;
import hackerton.refactor.domain.entity.member.QMemberDocumentCheck;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.data.domain.SliceImpl;

import java.util.List;

import static hackerton.refactor.domain.entity.announce.QAnnounce.announce;
import static hackerton.refactor.domain.entity.member.QMemberDocumentCheck.memberDocumentCheck;
import static hackerton.refactor.domain.entity.member.QMemberFavorite.memberFavorite;

@RequiredArgsConstructor
public class FavoriteQueryRepositoryImpl implements FavoriteQueryRepository{
    private final JPAQueryFactory queryFactory;

    @Override
    public Slice<FavoriteResponse> findFavoritesByMemberId(Long memberId, Pageable pageable) {
        List<FavoriteResponse> content = queryFactory
                .select(Projections.constructor(FavoriteResponse.class,
                        announce.id,
                        announce.title,
                        announce.reqstEndDate,
                        announce.documents.size(),
                        memberDocumentCheck.count().intValue()
                ))
                .from(memberFavorite)
                .join(memberFavorite.announce, announce)
                .leftJoin(memberDocumentCheck)
                .on(memberDocumentCheck.member.id.eq(memberId)
                        .and(memberDocumentCheck.document.announce.id.eq(announce.id)))
                .where(memberFavorite.member.id.eq(memberId))
                .groupBy(announce.id)
                .offset(pageable.getOffset())
                .limit(pageable.getPageSize() + 1) // 다음 페이지 존재 여부 확인용
                .fetch();

        boolean hasNext = false;
        if (content.size() > pageable.getPageSize()) {
            content.remove(pageable.getPageSize());
            hasNext = true;
        }

        return new SliceImpl<>(content, pageable, hasNext);
    }
}

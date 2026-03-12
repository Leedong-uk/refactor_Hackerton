package hackerton.refactor.domain.repository.favorite;

import com.querydsl.core.types.Projections;
import com.querydsl.jpa.impl.JPAQueryFactory;
import hackerton.refactor.domain.dto.document.DocumentItemDto;
import hackerton.refactor.domain.dto.favorite.FavoriteResponse;
import hackerton.refactor.domain.entity.announce.Document;
import hackerton.refactor.domain.entity.announce.QDocument;
import hackerton.refactor.domain.entity.member.QMemberDocumentCheck;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.data.domain.SliceImpl;

import java.util.List;

import static hackerton.refactor.domain.entity.announce.QAnnounce.announce;
import static hackerton.refactor.domain.entity.announce.QDocument.document;
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

    @Override
    public List<DocumentItemDto> findCheckListWithChecked(Long announceId, Long memberId) {
        return queryFactory
                .select(Projections.constructor(
                        DocumentItemDto.class,
                        document.id,
                        document.title,
                        document.description,
                        memberDocumentCheck.id.isNotNull()
                ))
                .from(document)
                .leftJoin(memberDocumentCheck)
                .on(
                        memberDocumentCheck.document.id.eq(document.id),
                        memberDocumentCheck.member.id.eq(memberId)
                )
                .where(document.announce.id.eq(announceId))
                .fetch();
    }


}

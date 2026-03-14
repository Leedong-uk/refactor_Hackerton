package hackerton.refactor.domain.repository.document;

import com.querydsl.core.types.Projections;
import com.querydsl.jpa.JPAExpressions;
import com.querydsl.jpa.impl.JPAQueryFactory;
import hackerton.refactor.domain.dto.document.DocumentCheckItemDto;
import lombok.RequiredArgsConstructor;

import java.util.List;

import static hackerton.refactor.domain.entity.document.QDocument.document;
import static hackerton.refactor.domain.entity.document.QMemberDocumentCheck.memberDocumentCheck;

@RequiredArgsConstructor
public class MemberDocumentQueryRepositoryImpl implements MemberDocumentQueryRepository{

    private final JPAQueryFactory queryFactory;

    @Override
    public List<DocumentCheckItemDto> findChecklist(Long memberId, Long announceId) {
         return queryFactory.select(Projections.constructor(DocumentCheckItemDto.class,
                        document.id, document.title ,memberDocumentCheck.checked.coalesce(false)))
                .from(document)
                .leftJoin(memberDocumentCheck)
                .on(memberDocumentCheck.document.id.eq(document.id),
                        memberDocumentCheck.member.id.eq(memberId))
                .where(document.announce.id.eq(announceId))
                .fetch();

    }

    @Override
    public void deleteChecklist(Long memberId, Long announceId) {
        queryFactory
                .delete(memberDocumentCheck)
                .where(
                        memberDocumentCheck.member.id.eq(memberId),
                        memberDocumentCheck.document.announce.id.eq(announceId)
                )
                .execute();
    }

}

package hackerton.refactor.domain.repository.notice;

import com.querydsl.core.types.Projections;
import com.querydsl.jpa.impl.JPAQueryFactory;
import hackerton.refactor.domain.dto.notice.NoticeDetailResponse;
import hackerton.refactor.domain.dto.notice.NoticeResponse;
import hackerton.refactor.domain.entity.notice.NoticeStatus;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.data.domain.SliceImpl;

import java.util.List;

import static hackerton.refactor.domain.entity.notice.QNotice.notice;

@RequiredArgsConstructor
public class NoticeQueryRepositoryImpl implements NoticeQueryRepository{

    private final JPAQueryFactory queryFactory;

    @Override
    public Slice<NoticeResponse> getAllNotice(Pageable pageable) {
        List<NoticeResponse> content = queryFactory
                .select(Projections.constructor(NoticeResponse.class,
                        notice.id,
                        notice.title))
                .from(notice)
                .where(notice.status.eq(NoticeStatus.PUBLISHED)) // 비공개 공지 제외 보안 필터링
                .offset(pageable.getOffset())
                .limit(pageable.getPageSize() + 1) // 1개 더 조회하여 hasNext 확인
                .orderBy(notice.id.desc())
                .fetch();

        // 다음 페이지 여부 확인
        boolean hasNext = false;
        if (content.size() > pageable.getPageSize()) {
            content.remove(pageable.getPageSize()); // 추가로 가져온 1개 삭제
            hasNext = true;
        }

        return new SliceImpl<>(content, pageable, hasNext);
    }

    @Override
    public NoticeDetailResponse getNoticeDetailById(Long noticeId) {
        return queryFactory.select(Projections.constructor(NoticeDetailResponse.class,
                        notice.id,
                        notice.title,
                        notice.content))
                .from(notice)
                .where(notice.id.eq(noticeId))
                .fetchOne();
    }
}

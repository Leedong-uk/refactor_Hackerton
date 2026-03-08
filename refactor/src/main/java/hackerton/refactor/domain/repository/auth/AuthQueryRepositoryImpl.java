package hackerton.refactor.domain.repository.auth;

import com.querydsl.jpa.impl.JPAQueryFactory;
import hackerton.refactor.domain.entity.auth.AuthStatus;
import lombok.RequiredArgsConstructor;

import java.util.List;

import static hackerton.refactor.domain.entity.auth.QAuth.auth;

@RequiredArgsConstructor
public class AuthQueryRepositoryImpl implements AuthQueryRepository{

    private final JPAQueryFactory queryFactory;

    @Override
    public List<AuthStatus> findStatusesByMemberId(Long memberId) {
        return queryFactory.select(auth.status)
                .from(auth)
                .where(auth.member.id.eq(memberId))
                .fetch();
    }
}

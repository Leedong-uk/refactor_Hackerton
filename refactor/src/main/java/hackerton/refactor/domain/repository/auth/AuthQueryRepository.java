package hackerton.refactor.domain.repository.auth;


import hackerton.refactor.domain.entity.auth.AuthStatus;

import java.util.List;

public interface AuthQueryRepository {
    List<AuthStatus> findStatusesByMemberId(Long memberId);
}

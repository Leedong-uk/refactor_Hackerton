package hackerton.refactor.domain.repository.business;

import hackerton.refactor.domain.entity.business.Business;

public interface BusinessQueryRepository {
    Business findBusinessWithMember(Long memberId);
}

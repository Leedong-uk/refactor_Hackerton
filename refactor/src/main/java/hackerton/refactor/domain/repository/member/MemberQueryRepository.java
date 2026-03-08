package hackerton.refactor.domain.repository.member;


import hackerton.refactor.domain.dto.member.MemberBusinessProfileDto;

public interface MemberQueryRepository {
    MemberBusinessProfileDto findMemberWithBusinessAndProfile(Long memberId);
}

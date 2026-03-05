package hackerton.refactor.domain.service;

import hackerton.refactor.domain.dto.SignUpRequestDto;
import hackerton.refactor.domain.entity.member.Auth;
import hackerton.refactor.domain.entity.member.AuthStatus;
import hackerton.refactor.domain.entity.member.Member;
import hackerton.refactor.domain.entity.member.ProfileImage;
import hackerton.refactor.domain.repository.AuthRepository;
import hackerton.refactor.domain.repository.MemberRepository;
import hackerton.refactor.domain.repository.ProfileImageRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class MemberService {
    private final MemberRepository memberRepository;
    private final ProfileImageRepository profileImageRepository;
    private final AuthRepository authRepository;

    @Transactional
    public Long singUp(SignUpRequestDto request) {
        Member member = Member.of(request);
        Member savedMember = memberRepository.save(member);

        ProfileImage profileImage = ProfileImage.of(request.getProfileImageKey(),savedMember);
        profileImageRepository.save(profileImage);

        Auth auth = new Auth(savedMember, AuthStatus.USER);
        authRepository.save(auth);

        return member.getId();
    }

}

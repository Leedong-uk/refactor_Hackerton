package hackerton.refactor.domain.service;

import hackerton.refactor.domain.dto.member.SignUpRequestDto;
import hackerton.refactor.domain.entity.member.Auth;
import hackerton.refactor.domain.entity.member.Member;
import hackerton.refactor.domain.entity.member.ProfileImage;
import hackerton.refactor.domain.repository.AuthRepository;
import hackerton.refactor.domain.repository.MemberRepository;
import hackerton.refactor.domain.repository.ProfileImageRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class MemberService {
    private final MemberRepository memberRepository;
    private final ProfileImageRepository profileImageRepository;
    private final AuthRepository authRepository;
    private final PasswordEncoder passwordEncoder;

    /**
     * 회원가입
     */
    @Transactional
    public Long singUp(SignUpRequestDto request) {
        Member member = Member.of(request);
        String encodedPassword = passwordEncoder.encode(request.getPassword());
        member.setPassword(encodedPassword);

        Member savedMember = memberRepository.save(member);

        ProfileImage profileImage = ProfileImage.of(request.getProfileImageKey(),savedMember);
        profileImageRepository.save(profileImage);

        Auth auth = new Auth();
        auth.addMember(member);
        authRepository.save(auth);

        return member.getId();
    }


    /**
     * 회원 탈퇴
     */
    @Transactional
    public void signOut(Long id) {
        memberRepository.removeById(id);
    }

    /**
     * 비밀 번호 변경
     */
    @Transactional
    public void updatePassword(Long memberId, String newPassword) {
        if (memberId == 0 || newPassword.isEmpty()) {
            throw new IllegalArgumentException("비밀번호 변경에 실패 했습니다");
        }
        Member findMember = memberRepository.findMemberById(memberId);
        findMember.setPassword(newPassword);
    }


}

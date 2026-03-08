package hackerton.refactor.domain.service;

import hackerton.refactor.domain.dto.member.MemberInfoResponse;
import hackerton.refactor.domain.dto.member.SignUpRequestDto;
import hackerton.refactor.domain.entity.business.Business;
import hackerton.refactor.domain.entity.business.BusinessCode;
import hackerton.refactor.domain.entity.member.Auth;
import hackerton.refactor.domain.entity.member.Member;
import hackerton.refactor.domain.entity.member.ProfileImage;
import hackerton.refactor.domain.repository.business.BusinessCodeRepository;
import hackerton.refactor.domain.repository.member.MemberRepository;
import hackerton.refactor.general.enums.BadStatusCode;
import hackerton.refactor.general.exception.BadRequestException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
@Slf4j
public class MemberService {
    private final MemberRepository memberRepository;
    private final PasswordEncoder passwordEncoder;
    private final BusinessCodeRepository businessCodeRepository;

    /**
     * 회원가입
     */
    @Transactional
    public Long signUp(SignUpRequestDto request) {
        // 1. 공통 코드 조회 (BusinessCode는 영속성 전이 대상이 아님)
        BusinessCode businessCode = businessCodeRepository.findBusinessCodeByMinorName(request.getMinorName());

        // 2. Member 생성
        Member member = Member.of(request);
        member.setPassword(passwordEncoder.encode(request.getPassword()));

        // 3. Business 생성
        Business business = Business.of(request);
        business.setBusinessCode(businessCode);
        business.addMember(member);

        // 4. 권한 및 프로필 이미지 설정
        Auth auth = new Auth();
        auth.addMember(member);

        ProfileImage profileImage = new ProfileImage();
        if (request.getProfileImageKey().isEmpty()) {
            profileImage.setStorageKey("/images/default-profile.png");
        } else {
            profileImage.setStorageKey(request.getProfileImageKey());
        }
        profileImage.addMember(member);


        // 5. 최종 저장
        memberRepository.save(member);

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
            throw new BadRequestException(BadStatusCode.INVALID_PARAMETER_EXCEPTION);
        }
        Member findMember = memberRepository.findMemberById(memberId);
        findMember.setPassword(newPassword);
    }

    /**
     * 회원 정보 불러오기
     */
    public MemberInfoResponse getMemberInfo(Long id) {
        Member findMember = memberRepository.findMemberWithBusinessAndProfileImage(id);
        findMember.getBusiness().getBusinessCode().getMinorName();
        return new MemberInfoResponse(findMember.getName(), findMember.getProfileImage().getStorageKey(), findMember.getBadge(), findMember.getBusiness().getName(), findMember.getBusiness().getBusinessCode().getMinorName());
    }


}

package hackerton.refactor.service;

import hackerton.refactor.domain.dto.SignUpRequestDto;
import hackerton.refactor.domain.entity.member.Member;
import hackerton.refactor.domain.repository.AuthRepository;
import hackerton.refactor.domain.repository.MemberRepository;
import hackerton.refactor.domain.repository.ProfileImageRepository;
import hackerton.refactor.domain.service.MemberService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@Transactional
class MemberServiceTest {
    @Autowired MemberService memberService;
    @Autowired MemberRepository memberRepository;
    @Autowired ProfileImageRepository profileImageRepository;
    @Autowired AuthRepository authRepository;

    @Test
    @DisplayName("회원가입Test")
    void 회원가입Test() throws Exception {
        //given
        SignUpRequestDto signUp1 = new SignUpRequestDto("test1@naver.com", "1234", "test1", "kakao1", "profile_storage_key_1");
        SignUpRequestDto signUp2 = new SignUpRequestDto("test2@naver.com", "1234", "test2", "kakao2", "profile_storage_key_2");


        //when
        Long saved1 = memberService.singUp(signUp1);
        Long saved2 = memberService.singUp(signUp2);

        Member findMember1 = memberRepository.findMemberById(saved1);
        Member findMember2 = memberRepository.findMemberById(saved2);

        //then

        //멤버 검증
        assertThat(findMember1.getId()).isEqualTo(saved1);
        assertThat(findMember2.getId()).isEqualTo(saved2);

        //프로필 이미지 검증
        assertThat(profileImageRepository.findProfileImageByMember(findMember1).getMember()).isEqualTo(findMember1);
        assertThat(profileImageRepository.findProfileImageByMember(findMember2).getMember()).isEqualTo(findMember2);

        //Auth 검증
        assertThat(authRepository.findAuthByMember(findMember1).getMember()).isEqualTo(findMember1);
        assertThat(authRepository.findAuthByMember(findMember2).getMember()).isEqualTo(findMember2);
    }


}
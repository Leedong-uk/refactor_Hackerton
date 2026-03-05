package hackerton.refactor.service;

import hackerton.refactor.domain.dto.member.SignUpRequestDto;
import hackerton.refactor.domain.entity.member.AuthStatus;
import hackerton.refactor.domain.entity.member.Member;
import hackerton.refactor.domain.repository.MemberRepository;
import hackerton.refactor.domain.service.MemberService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

@SpringBootTest
@Transactional
@Slf4j
class MemberServiceTest {
    @Autowired MemberService memberService;
    @Autowired MemberRepository memberRepository;



    @Test
    @DisplayName("회원가입Test")
    void 회원가입Test() throws Exception {

        //given
        SignUpRequestDto signUp1 = new SignUpRequestDto("test1@naver.com", "1234", "test1", "kakao1", "profile_storage_key_1");
        Long saved1 = memberService.singUp(signUp1);

        //when
        Member findMember1 = memberRepository.findMemberById(saved1);

        //then
        assertThat(findMember1.getId()).isEqualTo(saved1);
        assertThat(findMember1.getEmail()).isEqualTo("test1@naver.com");
        assertThat(findMember1.getPassword()).isEqualTo("1234");
        assertThat(findMember1.getName()).isEqualTo("test1");
        assertThat(findMember1.getKakaoId()).isEqualTo("kakao1");
        assertThat(findMember1.getProfileImages().get(0).getStorageKey()).isEqualTo("profile_storage_key_1");
        assertThat(findMember1.getAuths().get(0).getStatus()).isEqualTo(AuthStatus.USER);
    }

    @Test
    @DisplayName("회원탈퇴Test")
    void 회원탈퇴Test() throws Exception {
        //given
        SignUpRequestDto signUp1 = new SignUpRequestDto("test1@naver.com", "1234", "test1", "kakao1", "profile_storage_key_1");


        Long saved1 = memberService.singUp(signUp1);

        //when
        memberService.signOut(saved1);

        //then
        assertThat(memberRepository.findMemberById(saved1)).isNull();

    }





}
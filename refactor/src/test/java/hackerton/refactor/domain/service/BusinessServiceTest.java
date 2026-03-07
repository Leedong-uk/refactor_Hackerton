package hackerton.refactor.domain.service;

import hackerton.refactor.domain.dto.member.BusinessUpdateRequest;
import hackerton.refactor.domain.dto.member.SignUpRequestDto;
import hackerton.refactor.domain.entity.member.Member;
import hackerton.refactor.domain.repository.member.MemberRepository;
import jakarta.persistence.EntityManager;
import lombok.extern.slf4j.Slf4j;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;

import static org.assertj.core.api.Assertions.assertThat;


@SpringBootTest
@Transactional
@Slf4j
class BusinessServiceTest {

    @Autowired MemberService memberService;
    @Autowired MemberRepository memberRepository;
    @Autowired BusinessService businessService;
    @Autowired EntityManager em;

    @Test
    @DisplayName("BusinessUpdateTest")
    void businessUpdateTest() throws Exception {
        //given
        SignUpRequestDto signUprequestDto = new SignUpRequestDto("test@naver.com", "1234", "test",
                "kakao_1", "profileImage1",
                "111-11-1111", "동욱 태권도장",
                LocalDate.of(2026, 3, 1),
                "서울특별시", "동작구 보라매 파크빌",
                "태권도장");
        BusinessUpdateRequest businessUpdateRequest = new BusinessUpdateRequest("222-22-2222", "test2",
                "동욱 태권도장 2호점", LocalDate.now(),
                "태권도장", "서울특별시",
                "동작구 보라매 파크빌");

        //when
        Long newMemberId = memberService.signUp(signUprequestDto);
        businessService.updateBusiness(newMemberId,businessUpdateRequest);

        em.flush();
        em.clear();

        //then
        Member findMember = memberRepository.findMemberFetchWithBusiness(newMemberId);
        assertThat(findMember.getName()).isEqualTo("test2");


    }


}
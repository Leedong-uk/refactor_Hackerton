//package hackerton.refactor.domain.service;
//
//import hackerton.refactor.domain.dto.member.SignUpRequestDto;
//import org.junit.jupiter.api.DisplayName;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.transaction.annotation.Transactional;
//
//import java.time.LocalDate;
//
//import static org.junit.jupiter.api.Assertions.*;
//
//@SpringBootTest
//@Transactional
//class MemberServiceTest {
//    @Autowired
//    MemberService memberService;
//
//    @Test
//    @DisplayName("회원가입")
//     void 회원가입() throws Exception {
//        //given
//        SignUpRequestDto signUpRequestDto = new SignUpRequestDto("test1@naver.com", "1234", "testUser", "kakaoTest", "testProfileKey", "111-111-111", "동욱태권도장", LocalDate.now(), "서울특별시 동작구", "보라매파크빌", "태권도장");
//
//        //when
//        memberService.signUp(signUpRequestDto);
//
//        //then
//
//    }
//
//
//}
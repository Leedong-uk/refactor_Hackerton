package hackerton.refactor.general.init;

import hackerton.refactor.domain.dto.member.SignUpRequestDto;
import hackerton.refactor.domain.service.MemberService;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Configuration
@RequiredArgsConstructor
public class SampleData {
    private final InitService initService;

    @PostConstruct
    @Profile("local")
    public void init() {
        initService.init();
    }

    @Service
    @Transactional
    @RequiredArgsConstructor
    static class InitService {
        private final MemberService memberService;

        public void init() {
            SignUpRequestDto signUp1 = new SignUpRequestDto("test1@naver.com", "1234", "test1", "kakao1", "profile_storage_key_1");
            SignUpRequestDto signUp2 = new SignUpRequestDto("test1@naver.com", "1234", "test1", "kakao1", "profile_storage_key_1");
            SignUpRequestDto signUp3 = new SignUpRequestDto("test1@naver.com", "1234", "test1", "kakao1", "profile_storage_key_1");
            SignUpRequestDto signUp4 = new SignUpRequestDto("test1@naver.com", "1234", "test1", "kakao1", "profile_storage_key_1");
            SignUpRequestDto signUp5 = new SignUpRequestDto("test1@naver.com", "1234", "test1", "kakao1", "profile_storage_key_1");

            memberService.singUp(signUp1);
            memberService.singUp(signUp2);
            memberService.singUp(signUp3);
            memberService.singUp(signUp4);
            memberService.singUp(signUp5);

        }

    }
}

package hackerton.refactor.web.controller.member;

import hackerton.refactor.domain.dto.member.SignUpRequestDto;
import hackerton.refactor.domain.service.MemberService;
import hackerton.refactor.general.response.ApiSuccess;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {
    private final MemberService memberService;

    @PostMapping("/member-info")
    @ApiSuccess(statusCode = HttpStatus.CREATED, message = "user.signup")
    public void signUpMember(@RequestBody SignUpRequestDto dto) {
        memberService.signUp(dto);

    }
}

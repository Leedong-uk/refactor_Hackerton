package hackerton.refactor.web.controller.member;

import hackerton.refactor.domain.dto.member.SignUpRequestDto;
import hackerton.refactor.domain.service.MemberService;
import hackerton.refactor.general.response.ApiSuccess;
import hackerton.refactor.general.security.userdetail.CustomUser;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

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

    /**
     *  회원 탈퇴
     */
    @DeleteMapping("/member-info")
    @ApiSuccess(statusCode = HttpStatus.NO_CONTENT , message = "user.signout")
    public void signOutMember(@AuthenticationPrincipal CustomUser user ) {
        memberService.signOut(user.getMemberId());
    }


    /**
     * 회원 정보 수정 -> 더티 체킹
     */

    /**
     * 회원 정보
     */

    /**
     * 이메일 인증
     */
}

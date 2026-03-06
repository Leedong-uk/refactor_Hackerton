package hackerton.refactor.web.controller;

import hackerton.refactor.domain.dto.member.ChangePasswordRequest;
import hackerton.refactor.domain.service.MemberService;
import hackerton.refactor.general.response.ApiSuccess;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@Slf4j
public class MemberController {
    private final MemberService memberService;

    @PatchMapping("/password")
    @ApiSuccess(message = "password.change.success")
    public void changePassword(@RequestBody ChangePasswordRequest request) {
        memberService.updatePassword(request.getId(), request.getNewPassword());
    }

}

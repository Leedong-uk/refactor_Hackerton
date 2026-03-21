package hackerton.refactor.web.controller.email;

import hackerton.refactor.domain.dto.email.MailRequest;
import hackerton.refactor.domain.service.EmailService;
import hackerton.refactor.general.response.ApiSuccess;
import hackerton.refactor.general.security.userdetail.CustomUser;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class EmailController {
    private final EmailService emailService;

    @PostMapping("email")
    @ApiSuccess(message = "email.send")
    public void sendEmail(@RequestBody MailRequest request) {
        emailService.sendEmail(request);
    }
}

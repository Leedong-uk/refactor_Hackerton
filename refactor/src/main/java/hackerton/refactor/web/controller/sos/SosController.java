package hackerton.refactor.web.controller.sos;

import hackerton.refactor.domain.dto.SosCreateRequest;
import hackerton.refactor.domain.service.SosService;
import hackerton.refactor.general.response.ApiSuccess;
import hackerton.refactor.general.security.userdetail.CustomUser;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class SosController {

    private final SosService sosService;

    @PostMapping("/sos")
    @ApiSuccess(message = "sos.create")
    public void createSos(@AuthenticationPrincipal CustomUser user, @RequestBody SosCreateRequest request) {
        sosService.createSos(user.getMemberId(),request);
    }
}

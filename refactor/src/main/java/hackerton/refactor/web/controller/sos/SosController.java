package hackerton.refactor.web.controller.sos;

import hackerton.refactor.domain.dto.sos.SosCreateRequest;
import hackerton.refactor.domain.dto.sos.SosUpdateRequest;
import hackerton.refactor.domain.service.SosService;
import hackerton.refactor.general.response.ApiSuccess;
import hackerton.refactor.general.security.userdetail.CustomUser;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class SosController {

    private final SosService sosService;

    @PostMapping("/sos")
    @ApiSuccess(message = "sos.create")
    public void createSos(@AuthenticationPrincipal CustomUser user, @RequestBody SosCreateRequest request) {
        sosService.createSos(user.getMemberId(),request);
    }

    @PutMapping("/sos/{sosId}")
    @ApiSuccess(message = "sos.update")
    public void updateSos(@AuthenticationPrincipal CustomUser user,
                          @PathVariable Long sosId,
                          @RequestBody SosUpdateRequest request) {
        sosService.updateSos(user.getMemberId(),sosId,request);
    }

    @DeleteMapping("/sos/{sosId}")
    @ApiSuccess(message = "sos.delete")
    public void deleteSos(@AuthenticationPrincipal CustomUser user ,
                          @PathVariable Long sosId) {
        sosService.deleteSos(user.getMemberId(),sosId);
    }

}

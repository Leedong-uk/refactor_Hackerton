package hackerton.refactor.web.controller.sos;

import hackerton.refactor.domain.dto.sos.SosCreateRequest;
import hackerton.refactor.domain.dto.sos.SosDetailResponse;
import hackerton.refactor.domain.dto.sos.SosListResponse;
import hackerton.refactor.domain.dto.sos.SosUpdateRequest;
import hackerton.refactor.domain.service.SosService;
import hackerton.refactor.general.response.ApiSuccess;
import hackerton.refactor.general.security.userdetail.CustomUser;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @GetMapping("/sos")
    @ApiSuccess(message = "sos.list")
    public List<SosListResponse> getSosList() {
        return sosService.getSosList();
    }

    @GetMapping("/sos/{sosId}")
    @ApiSuccess(message = "sos.detail")
    public SosDetailResponse getDetail(@PathVariable Long sosId) {
        return sosService.getSosDetail(sosId);
    }

}

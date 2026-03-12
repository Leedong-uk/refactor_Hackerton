package hackerton.refactor.web.controller.announce;

import hackerton.refactor.domain.dto.announce.AnnounceDetailResponse;
import hackerton.refactor.domain.dto.announce.AnnounceResponse;
import hackerton.refactor.domain.service.AnnounceService;
import hackerton.refactor.general.response.ApiSuccess;
import hackerton.refactor.general.security.userdetail.CustomUser;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class AnnounceController {
    private final AnnounceService announceService;

    @GetMapping("/announce")
    @ApiSuccess(message = "announce.list")
    public List<AnnounceResponse> getAnnounce(@AuthenticationPrincipal CustomUser user, Pageable pageable) {
        return announceService.getAnnounce(user.getMemberId(),pageable).getContent();
    }


    @GetMapping("/announce/{announceId}")
    @ApiSuccess(message = "announce.detail")
    public AnnounceDetailResponse getAnnounceDetail(@PathVariable Long announceId) {
        return announceService.getAnnounceDetailAndPlus(announceId);
    }

}

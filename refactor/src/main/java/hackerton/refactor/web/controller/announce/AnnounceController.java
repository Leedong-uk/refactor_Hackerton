package hackerton.refactor.web.controller.announce;

import hackerton.refactor.domain.dto.announce.AnnounceListResponse;
import hackerton.refactor.domain.service.AnnounceService;
import hackerton.refactor.general.response.ApiSuccess;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class AnnounceController {
    private final AnnounceService announceService;

    @GetMapping("/announce")
    @ApiSuccess(message = "announce.list")
    public AnnounceListResponse getAnnounce(Pageable pageable) {
        return announceService.getAnnounce(pageable);
    }

}

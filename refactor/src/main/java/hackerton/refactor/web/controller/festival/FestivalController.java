package hackerton.refactor.web.controller.festival;

import hackerton.refactor.domain.dto.festival.FestivalDetailResponse;
import hackerton.refactor.domain.dto.festival.FestivalResponse;
import hackerton.refactor.domain.service.FestivalService;
import hackerton.refactor.general.response.ApiSuccess;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class FestivalController {
    private final FestivalService festivalService;

    @GetMapping("/festival")
    @ApiSuccess(message = "festival.list")
    public List<FestivalResponse> getAllFestival(Pageable pageable) {
        return festivalService.getFestivalList(pageable);
    }

    @GetMapping("/festival/{festivalId}")
    @ApiSuccess(message = "festival.detail")
    public FestivalDetailResponse getFestivalDetail(@PathVariable Long festivalId) {
        return festivalService.getFestivalDetail(festivalId);
    }
}

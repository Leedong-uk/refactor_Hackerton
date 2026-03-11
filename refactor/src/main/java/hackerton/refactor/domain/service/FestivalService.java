package hackerton.refactor.domain.service;

import hackerton.refactor.domain.dto.festival.FestivalDetailResponse;
import hackerton.refactor.domain.dto.festival.FestivalResponse;
import hackerton.refactor.domain.entity.festival.Festival;
import hackerton.refactor.domain.repository.festival.FestivalRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
@Transactional(readOnly = true)
@Slf4j
public class FestivalService {
    private final FestivalRepository festivalRepository;

    public List<FestivalResponse> getFestivalList(Pageable pageable) {
        return festivalRepository.findAllBy(pageable)
                .map(FestivalResponse::of)
                .getContent();
    }

    public FestivalDetailResponse getFestivalDetail(Long festivalId) {
        Festival festival = festivalRepository.findFestivalById(festivalId);
        return FestivalDetailResponse.of(festival);
    }
}

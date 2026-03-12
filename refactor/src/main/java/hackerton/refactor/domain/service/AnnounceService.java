package hackerton.refactor.domain.service;

import hackerton.refactor.domain.dto.announce.AnnounceDetailResponse;
import hackerton.refactor.domain.dto.announce.AnnounceResponse;
import hackerton.refactor.domain.dto.document.DocumentItemDto;
import hackerton.refactor.domain.entity.announce.Announce;
import hackerton.refactor.domain.repository.announce.AnnounceRepository;
import hackerton.refactor.domain.repository.favorite.FavoriteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class AnnounceService {
    private final AnnounceRepository announceRepository;
    private final FavoriteRepository favoriteRepository;

    public Slice<AnnounceResponse> getAnnounce(Long memberId ,Pageable pageable) {
        return announceRepository.findAnnounceWithFavorite(memberId, pageable);
    }


    @Transactional
    public AnnounceDetailResponse getAnnounceDetailAndPlus(Long announceId,Long memberId) {
        // 1. 조회수 증가
        announceRepository.updateViewNum(announceId);

        //2. 공고 조회
        Announce announce = announceRepository.findAnnounceById(announceId);

        //3. 체크리스트 조회
        List<DocumentItemDto> checkList = favoriteRepository.findCheckListWithChecked(announceId, memberId);

        //4. dto 생성
        AnnounceDetailResponse response = AnnounceDetailResponse.of(announce);
        response.setChecklist(checkList);

        return response;
    }




}

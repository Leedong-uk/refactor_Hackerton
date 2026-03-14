package hackerton.refactor.domain.service;

import hackerton.refactor.domain.dto.announce.AnnounceDetailResponse;
import hackerton.refactor.domain.dto.announce.AnnounceResponse;
import hackerton.refactor.domain.dto.document.DocumentCheckItemDto;
import hackerton.refactor.domain.entity.announce.Announce;
import hackerton.refactor.domain.repository.announce.AnnounceRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class AnnounceService {
    private final AnnounceRepository announceRepository;
    private final MemberDocumentCheckService memberDocumentCheckService;

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
        List<DocumentCheckItemDto> allChecklist = memberDocumentCheckService.getAllChecklist(memberId, announceId);

        //4. dto 생성
        AnnounceDetailResponse response = AnnounceDetailResponse.of(announce);
        response.setChecklist(allChecklist);


        return response;
    }




}

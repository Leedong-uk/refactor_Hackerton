package hackerton.refactor.domain.service;

import hackerton.refactor.domain.dto.announce.AnnounceDetailResponse;
import hackerton.refactor.domain.dto.announce.AnnounceResponse;
import hackerton.refactor.domain.dto.document.DocumentItemDto;
import hackerton.refactor.domain.entity.announce.Announce;
import hackerton.refactor.domain.repository.announce.AnnounceRepository;
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

    public Slice<AnnounceResponse> getAnnounce(Long memberId ,Pageable pageable) {
        return announceRepository.findAnnounceWithFavorite(memberId, pageable);
    }

//    @Transactional
//    public AnnounceDetailResponse getAnnounceDetail(Long announceId) {
//        Announce announce = announceRepository.findAnnounceById(announceId);
//        announce.setViewNum(announce.getViewNum() + 1);
//        AnnounceDetailResponse response = AnnounceDetailResponse.of(announce);
//
//        List<Document> documentList = documentRepository.findDocumentByAnnounce_Id(announceId);
//        List<DocumentItemDto> checklist = documentList.stream()
//                .map(doc -> DocumentItemDto.of(doc)) // Document → DTO 변환 메서드 필요
//                .toList();
//
//        response.setChecklist(checklist);
//        return response;
//    }

    @Transactional
    public AnnounceDetailResponse getAnnounceDetail(Long announceId) {
        // 1. 벌크 연산
        announceRepository.updateViewNum(announceId);

        Announce announce = announceRepository.findAnnounceWithDocuments(announceId);
        List<DocumentItemDto> checkList = announce.getDocuments().stream()
                .map(d -> DocumentItemDto.of(d))
                .collect(Collectors.toList());


        AnnounceDetailResponse response = AnnounceDetailResponse.of(announce);
        response.setChecklist(checkList);
        return response;
    }
}

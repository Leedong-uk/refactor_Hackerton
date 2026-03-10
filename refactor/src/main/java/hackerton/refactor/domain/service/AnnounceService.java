package hackerton.refactor.domain.service;

import hackerton.refactor.domain.dto.announce.AnnounceListResponse;
import hackerton.refactor.domain.entity.announce.Announce;
import hackerton.refactor.domain.repository.announce.AnnounceRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
@RequiredArgsConstructor
public class AnnounceService {
    private final AnnounceRepository announceRepository;

    public AnnounceListResponse getAnnounce(Pageable pageable) {
        Slice<Announce> slice = announceRepository.findAllBy(pageable);
        AnnounceListResponse result = new AnnounceListResponse();
        result.setAnnounces(new ArrayList<>(slice.getContent()));
        return result;
    }
}

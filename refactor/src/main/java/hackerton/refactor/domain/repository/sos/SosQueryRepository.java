package hackerton.refactor.domain.repository.sos;

import hackerton.refactor.domain.dto.sos.SosDetailResponse;
import hackerton.refactor.domain.dto.sos.SosListResponse;

import java.util.List;

public interface SosQueryRepository {
    List<SosListResponse> getAllSos();
    SosDetailResponse getSosDetail(Long sosId);
}

package hackerton.refactor.domain.repository.sos;

import hackerton.refactor.domain.dto.sos.SosListResponse;

import java.util.List;

public interface SosImageQueryRepository {
    long deleteAllBySosId(Long sosId);

    long deleteSosBulk(Long sosId);


}

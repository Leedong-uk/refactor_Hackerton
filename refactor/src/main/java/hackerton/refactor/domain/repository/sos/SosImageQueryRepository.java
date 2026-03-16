package hackerton.refactor.domain.repository.sos;

public interface SosImageQueryRepository {
    long deleteAllBySosId(Long sosId);

    long deleteSosBulk(Long sosId);
}

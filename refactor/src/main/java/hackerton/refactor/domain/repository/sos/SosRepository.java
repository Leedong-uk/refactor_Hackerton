package hackerton.refactor.domain.repository.sos;

import hackerton.refactor.domain.entity.sos.Sos;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SosRepository extends JpaRepository<Sos,Long> {
    Optional<Sos> findById(Long sosId);
}

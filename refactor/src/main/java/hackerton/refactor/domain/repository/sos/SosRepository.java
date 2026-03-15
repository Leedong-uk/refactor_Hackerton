package hackerton.refactor.domain.repository.sos;

import hackerton.refactor.domain.entity.sos.Sos;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SosRepository extends JpaRepository<Sos,Long> {
}

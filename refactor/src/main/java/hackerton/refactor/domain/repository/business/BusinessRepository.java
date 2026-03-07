package hackerton.refactor.domain.repository.business;

import hackerton.refactor.domain.entity.business.Business;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.RestController;

@RestController
public interface BusinessRepository extends JpaRepository<Business,Long> {

}

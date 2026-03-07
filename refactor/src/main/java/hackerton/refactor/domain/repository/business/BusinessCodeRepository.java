package hackerton.refactor.domain.repository.business;

import hackerton.refactor.domain.entity.business.BusinessCode;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BusinessCodeRepository extends JpaRepository<BusinessCode,Long> {
    BusinessCode findBusinessCodeByMinorName(String minorName);
}

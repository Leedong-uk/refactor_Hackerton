package hackerton.refactor.domain.repository.sos;

import com.querydsl.jpa.impl.JPAQueryFactory;

import lombok.RequiredArgsConstructor;
import static hackerton.refactor.domain.entity.sos.QSos.sos;
import static hackerton.refactor.domain.entity.sos.QSosImage.sosImage;

@RequiredArgsConstructor
public class SosImageQueryRepositoryImpl implements SosImageQueryRepository{

    private final JPAQueryFactory queryFactory;

    @Override
    public long deleteAllBySosId(Long sosId ) {
        return queryFactory
                .delete(sosImage)
                .where(sosImage.sos.id.eq(sosId))
                .execute();
    }

    @Override
    public long deleteSosBulk(Long sosId) {
        return queryFactory
                .delete(sos)
                .where(sos.id.eq(sosId))
                .execute();
    }


}

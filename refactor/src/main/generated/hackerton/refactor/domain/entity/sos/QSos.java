package hackerton.refactor.domain.entity.sos;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QSos is a Querydsl query type for Sos
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QSos extends EntityPathBase<Sos> {

    private static final long serialVersionUID = -1532174244L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QSos sos = new QSos("sos");

    public final hackerton.refactor.domain.entity.base.QBaseEntity _super = new hackerton.refactor.domain.entity.base.QBaseEntity(this);

    public final StringPath content = createString("content");

    //inherited
    public final StringPath createdBy = _super.createdBy;

    //inherited
    public final DateTimePath<java.time.LocalDateTime> createdDate = _super.createdDate;

    public final DateTimePath<java.time.LocalDateTime> expiredAt = createDateTime("expiredAt", java.time.LocalDateTime.class);

    public final NumberPath<Long> id = createNumber("id", Long.class);

    //inherited
    public final StringPath lastModifiedBy = _super.lastModifiedBy;

    //inherited
    public final DateTimePath<java.time.LocalDateTime> lastModifiedDate = _super.lastModifiedDate;

    public final hackerton.refactor.domain.entity.member.QMember member;

    public final EnumPath<SosStatus> status = createEnum("status", SosStatus.class);

    public final StringPath title = createString("title");

    public final EnumPath<SosType> type = createEnum("type", SosType.class);

    public QSos(String variable) {
        this(Sos.class, forVariable(variable), INITS);
    }

    public QSos(Path<? extends Sos> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QSos(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QSos(PathMetadata metadata, PathInits inits) {
        this(Sos.class, metadata, inits);
    }

    public QSos(Class<? extends Sos> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.member = inits.isInitialized("member") ? new hackerton.refactor.domain.entity.member.QMember(forProperty("member")) : null;
    }

}


package hackerton.refactor.domain.entity.sos;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QSosImage is a Querydsl query type for SosImage
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QSosImage extends EntityPathBase<SosImage> {

    private static final long serialVersionUID = 1167372895L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QSosImage sosImage = new QSosImage("sosImage");

    public final hackerton.refactor.domain.entity.base.QBaseEntity _super = new hackerton.refactor.domain.entity.base.QBaseEntity(this);

    //inherited
    public final StringPath createdBy = _super.createdBy;

    //inherited
    public final DateTimePath<java.time.LocalDateTime> createdDate = _super.createdDate;

    public final NumberPath<Long> id = createNumber("id", Long.class);

    //inherited
    public final StringPath lastModifiedBy = _super.lastModifiedBy;

    //inherited
    public final DateTimePath<java.time.LocalDateTime> lastModifiedDate = _super.lastModifiedDate;

    public final NumberPath<Integer> sortOrder = createNumber("sortOrder", Integer.class);

    public final QSos sos;

    public final StringPath storageKey = createString("storageKey");

    public QSosImage(String variable) {
        this(SosImage.class, forVariable(variable), INITS);
    }

    public QSosImage(Path<? extends SosImage> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QSosImage(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QSosImage(PathMetadata metadata, PathInits inits) {
        this(SosImage.class, metadata, inits);
    }

    public QSosImage(Class<? extends SosImage> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.sos = inits.isInitialized("sos") ? new QSos(forProperty("sos"), inits.get("sos")) : null;
    }

}


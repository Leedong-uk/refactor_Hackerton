package hackerton.refactor.domain.entity.business;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QBusiness is a Querydsl query type for Business
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QBusiness extends EntityPathBase<Business> {

    private static final long serialVersionUID = 1412442890L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QBusiness business = new QBusiness("business");

    public final hackerton.refactor.domain.entity.base.QBaseEntity _super = new hackerton.refactor.domain.entity.base.QBaseEntity(this);

    public final StringPath businessAddr = createString("businessAddr");

    public final StringPath businessAddrDetail = createString("businessAddrDetail");

    public final QBusinessCode businessCode;

    public final StringPath businessNumber = createString("businessNumber");

    public final DatePath<java.time.LocalDate> businessOpenDate = createDate("businessOpenDate", java.time.LocalDate.class);

    //inherited
    public final StringPath createdBy = _super.createdBy;

    //inherited
    public final DateTimePath<java.time.LocalDateTime> createdDate = _super.createdDate;

    public final NumberPath<Long> id = createNumber("id", Long.class);

    //inherited
    public final StringPath lastModifiedBy = _super.lastModifiedBy;

    //inherited
    public final DateTimePath<java.time.LocalDateTime> lastModifiedDate = _super.lastModifiedDate;

    public final hackerton.refactor.domain.entity.member.QMember member;

    public final StringPath name = createString("name");

    public QBusiness(String variable) {
        this(Business.class, forVariable(variable), INITS);
    }

    public QBusiness(Path<? extends Business> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QBusiness(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QBusiness(PathMetadata metadata, PathInits inits) {
        this(Business.class, metadata, inits);
    }

    public QBusiness(Class<? extends Business> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.businessCode = inits.isInitialized("businessCode") ? new QBusinessCode(forProperty("businessCode")) : null;
        this.member = inits.isInitialized("member") ? new hackerton.refactor.domain.entity.member.QMember(forProperty("member")) : null;
    }

}


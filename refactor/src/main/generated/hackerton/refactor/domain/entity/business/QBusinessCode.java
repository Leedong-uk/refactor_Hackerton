package hackerton.refactor.domain.entity.business;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QBusinessCode is a Querydsl query type for BusinessCode
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QBusinessCode extends EntityPathBase<BusinessCode> {

    private static final long serialVersionUID = 449820695L;

    public static final QBusinessCode businessCode = new QBusinessCode("businessCode");

    public final hackerton.refactor.domain.entity.base.QBaseTimeEntity _super = new hackerton.refactor.domain.entity.base.QBaseTimeEntity(this);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> createdDate = _super.createdDate;

    public final NumberPath<Long> id = createNumber("id", Long.class);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> lastModifiedDate = _super.lastModifiedDate;

    public final StringPath majorCode = createString("majorCode");

    public final StringPath majorName = createString("majorName");

    public final StringPath middleCode = createString("middleCode");

    public final StringPath middleName = createString("middleName");

    public final StringPath minorCode = createString("minorCode");

    public final StringPath minorName = createString("minorName");

    public QBusinessCode(String variable) {
        super(BusinessCode.class, forVariable(variable));
    }

    public QBusinessCode(Path<? extends BusinessCode> path) {
        super(path.getType(), path.getMetadata());
    }

    public QBusinessCode(PathMetadata metadata) {
        super(BusinessCode.class, metadata);
    }

}


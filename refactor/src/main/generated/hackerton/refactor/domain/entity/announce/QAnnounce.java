package hackerton.refactor.domain.entity.announce;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QAnnounce is a Querydsl query type for Announce
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QAnnounce extends EntityPathBase<Announce> {

    private static final long serialVersionUID = -1600497366L;

    public static final QAnnounce announce = new QAnnounce("announce");

    public final hackerton.refactor.domain.entity.base.QBaseEntity _super = new hackerton.refactor.domain.entity.base.QBaseEntity(this);

    public final StringPath author = createString("author");

    public final StringPath callCompany = createString("callCompany");

    //inherited
    public final StringPath createdBy = _super.createdBy;

    //inherited
    public final DateTimePath<java.time.LocalDateTime> createdDate = _super.createdDate;

    public final StringPath description = createString("description");

    public final StringPath excInsttNm = createString("excInsttNm");

    public final StringPath fileName = createString("fileName");

    public final StringPath filePath = createString("filePath");

    public final StringPath howToRegister = createString("howToRegister");

    public final NumberPath<Long> id = createNumber("id", Long.class);

    //inherited
    public final StringPath lastModifiedBy = _super.lastModifiedBy;

    //inherited
    public final DateTimePath<java.time.LocalDateTime> lastModifiedDate = _super.lastModifiedDate;

    public final StringPath lcategory = createString("lcategory");

    public final StringPath printFileName = createString("printFileName");

    public final StringPath printFilePath = createString("printFilePath");

    public final DateTimePath<java.time.LocalDateTime> pubDate = createDateTime("pubDate", java.time.LocalDateTime.class);

    public final DateTimePath<java.time.LocalDateTime> reqstEndDate = createDateTime("reqstEndDate", java.time.LocalDateTime.class);

    public final DateTimePath<java.time.LocalDateTime> reqstStartDate = createDateTime("reqstStartDate", java.time.LocalDateTime.class);

    public final StringPath targetName = createString("targetName");

    public final StringPath title = createString("title");

    public final NumberPath<Integer> viewNum = createNumber("viewNum", Integer.class);

    public QAnnounce(String variable) {
        super(Announce.class, forVariable(variable));
    }

    public QAnnounce(Path<? extends Announce> path) {
        super(path.getType(), path.getMetadata());
    }

    public QAnnounce(PathMetadata metadata) {
        super(Announce.class, metadata);
    }

}


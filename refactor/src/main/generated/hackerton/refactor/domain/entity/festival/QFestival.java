package hackerton.refactor.domain.entity.festival;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QFestival is a Querydsl query type for Festival
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QFestival extends EntityPathBase<Festival> {

    private static final long serialVersionUID = 941726218L;

    public static final QFestival festival = new QFestival("festival");

    public final hackerton.refactor.domain.entity.base.QBaseEntity _super = new hackerton.refactor.domain.entity.base.QBaseEntity(this);

    public final StringPath address = createString("address");

    public final NumberPath<Long> contentId = createNumber("contentId", Long.class);

    //inherited
    public final StringPath createdBy = _super.createdBy;

    //inherited
    public final DateTimePath<java.time.LocalDateTime> createdDate = _super.createdDate;

    public final StringPath detailAddress = createString("detailAddress");

    public final DatePath<java.time.LocalDate> eventEndDate = createDate("eventEndDate", java.time.LocalDate.class);

    public final DatePath<java.time.LocalDate> eventStartDate = createDate("eventStartDate", java.time.LocalDate.class);

    public final StringPath festivalTitle = createString("festivalTitle");

    public final StringPath firstImage = createString("firstImage");

    public final NumberPath<Long> id = createNumber("id", Long.class);

    //inherited
    public final StringPath lastModifiedBy = _super.lastModifiedBy;

    //inherited
    public final DateTimePath<java.time.LocalDateTime> lastModifiedDate = _super.lastModifiedDate;

    public final NumberPath<Double> mapX = createNumber("mapX", Double.class);

    public final NumberPath<Double> mapY = createNumber("mapY", Double.class);

    public final StringPath overview = createString("overview");

    public final StringPath tel = createString("tel");

    public final StringPath telName = createString("telName");

    public QFestival(String variable) {
        super(Festival.class, forVariable(variable));
    }

    public QFestival(Path<? extends Festival> path) {
        super(path.getType(), path.getMetadata());
    }

    public QFestival(PathMetadata metadata) {
        super(Festival.class, metadata);
    }

}


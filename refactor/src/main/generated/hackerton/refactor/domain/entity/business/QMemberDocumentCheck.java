package hackerton.refactor.domain.entity.business;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QMemberDocumentCheck is a Querydsl query type for MemberDocumentCheck
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QMemberDocumentCheck extends EntityPathBase<MemberDocumentCheck> {

    private static final long serialVersionUID = 305614505L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QMemberDocumentCheck memberDocumentCheck = new QMemberDocumentCheck("memberDocumentCheck");

    public final DateTimePath<java.time.LocalDateTime> checkedAt = createDateTime("checkedAt", java.time.LocalDateTime.class);

    public final hackerton.refactor.domain.entity.announce.QDocument document;

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final hackerton.refactor.domain.entity.member.QMember member;

    public QMemberDocumentCheck(String variable) {
        this(MemberDocumentCheck.class, forVariable(variable), INITS);
    }

    public QMemberDocumentCheck(Path<? extends MemberDocumentCheck> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QMemberDocumentCheck(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QMemberDocumentCheck(PathMetadata metadata, PathInits inits) {
        this(MemberDocumentCheck.class, metadata, inits);
    }

    public QMemberDocumentCheck(Class<? extends MemberDocumentCheck> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.document = inits.isInitialized("document") ? new hackerton.refactor.domain.entity.announce.QDocument(forProperty("document"), inits.get("document")) : null;
        this.member = inits.isInitialized("member") ? new hackerton.refactor.domain.entity.member.QMember(forProperty("member"), inits.get("member")) : null;
    }

}


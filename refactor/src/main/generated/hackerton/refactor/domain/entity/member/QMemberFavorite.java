package hackerton.refactor.domain.entity.member;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QMemberFavorite is a Querydsl query type for MemberFavorite
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QMemberFavorite extends EntityPathBase<MemberFavorite> {

    private static final long serialVersionUID = 625241862L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QMemberFavorite memberFavorite = new QMemberFavorite("memberFavorite");

    public final hackerton.refactor.domain.entity.announce.QAnnounce announce;

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final QMember member;

    public QMemberFavorite(String variable) {
        this(MemberFavorite.class, forVariable(variable), INITS);
    }

    public QMemberFavorite(Path<? extends MemberFavorite> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QMemberFavorite(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QMemberFavorite(PathMetadata metadata, PathInits inits) {
        this(MemberFavorite.class, metadata, inits);
    }

    public QMemberFavorite(Class<? extends MemberFavorite> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.announce = inits.isInitialized("announce") ? new hackerton.refactor.domain.entity.announce.QAnnounce(forProperty("announce")) : null;
        this.member = inits.isInitialized("member") ? new QMember(forProperty("member"), inits.get("member")) : null;
    }

}


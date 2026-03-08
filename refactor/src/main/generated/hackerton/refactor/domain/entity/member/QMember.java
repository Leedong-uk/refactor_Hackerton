package hackerton.refactor.domain.entity.member;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QMember is a Querydsl query type for Member
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QMember extends EntityPathBase<Member> {

    private static final long serialVersionUID = 324741962L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QMember member = new QMember("member1");

    public final hackerton.refactor.domain.entity.base.QBaseEntity _super = new hackerton.refactor.domain.entity.base.QBaseEntity(this);

    public final ListPath<Auth, QAuth> auths = this.<Auth, QAuth>createList("auths", Auth.class, QAuth.class, PathInits.DIRECT2);

    public final EnumPath<MemberBadge> badge = createEnum("badge", MemberBadge.class);

    public final hackerton.refactor.domain.entity.business.QBusiness business;

    //inherited
    public final StringPath createdBy = _super.createdBy;

    //inherited
    public final DateTimePath<java.time.LocalDateTime> createdDate = _super.createdDate;

    public final StringPath email = createString("email");

    public final StringPath fcmToken = createString("fcmToken");

    public final NumberPath<Integer> helpCount = createNumber("helpCount", Integer.class);

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final StringPath kakaoId = createString("kakaoId");

    //inherited
    public final StringPath lastModifiedBy = _super.lastModifiedBy;

    //inherited
    public final DateTimePath<java.time.LocalDateTime> lastModifiedDate = _super.lastModifiedDate;

    public final StringPath name = createString("name");

    public final StringPath password = createString("password");

    public final QProfileImage profileImage;

    public final EnumPath<hackerton.refactor.domain.entity.MemberStatus> status = createEnum("status", hackerton.refactor.domain.entity.MemberStatus.class);

    public QMember(String variable) {
        this(Member.class, forVariable(variable), INITS);
    }

    public QMember(Path<? extends Member> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QMember(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QMember(PathMetadata metadata, PathInits inits) {
        this(Member.class, metadata, inits);
    }

    public QMember(Class<? extends Member> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.business = inits.isInitialized("business") ? new hackerton.refactor.domain.entity.business.QBusiness(forProperty("business"), inits.get("business")) : null;
        this.profileImage = inits.isInitialized("profileImage") ? new QProfileImage(forProperty("profileImage"), inits.get("profileImage")) : null;
    }

}


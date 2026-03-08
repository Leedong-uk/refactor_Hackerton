package hackerton.refactor.domain.entity.member;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QAlarmPreference is a Querydsl query type for AlarmPreference
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QAlarmPreference extends EntityPathBase<AlarmPreference> {

    private static final long serialVersionUID = -1203943588L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QAlarmPreference alarmPreference = new QAlarmPreference("alarmPreference");

    public final DateTimePath<java.time.LocalDateTime> alarmEndTime = createDateTime("alarmEndTime", java.time.LocalDateTime.class);

    public final DateTimePath<java.time.LocalDateTime> alarmStartTime = createDateTime("alarmStartTime", java.time.LocalDateTime.class);

    public final BooleanPath announcePreference = createBoolean("announcePreference");

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final BooleanPath isAlarm = createBoolean("isAlarm");

    public final QMember member;

    public final BooleanPath sosPreference = createBoolean("sosPreference");

    public QAlarmPreference(String variable) {
        this(AlarmPreference.class, forVariable(variable), INITS);
    }

    public QAlarmPreference(Path<? extends AlarmPreference> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QAlarmPreference(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QAlarmPreference(PathMetadata metadata, PathInits inits) {
        this(AlarmPreference.class, metadata, inits);
    }

    public QAlarmPreference(Class<? extends AlarmPreference> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.member = inits.isInitialized("member") ? new QMember(forProperty("member"), inits.get("member")) : null;
    }

}


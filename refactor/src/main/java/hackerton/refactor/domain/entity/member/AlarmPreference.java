package hackerton.refactor.domain.entity.member;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Getter @Setter
@NoArgsConstructor
public class AlarmPreference {
    @Id
    @GeneratedValue
    @Column(name = "alarm_preference_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id",nullable = false)
    private Member member;

    @Column(nullable = false)
    private boolean sosPreference = false;

    @Column(nullable = false)
    private boolean announcePreference=false;

    private LocalDateTime alarmStartTime;
    private LocalDateTime alarmEndTime;

    @Column(nullable = false)
    private boolean isAlarm = false;

}

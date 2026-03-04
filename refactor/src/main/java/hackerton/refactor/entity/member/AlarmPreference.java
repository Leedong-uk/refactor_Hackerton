package hackerton.refactor.entity.member;

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

    @ManyToOne
    @JoinColumn(name = "member_id")
    private Member member;
    @Column(nullable = false)
    private Boolean sosPreference = false;
    @Column(nullable = false)
    private Boolean announcePreference=false;
    private LocalDateTime alarmStartTime;
    private LocalDateTime alarmEndTime;
    @Column(nullable = false)
    private Boolean isAlarm = false;

}

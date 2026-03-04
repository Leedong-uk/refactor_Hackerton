package hackerton.refactor.entity.business;

import hackerton.refactor.entity.base.BaseTimeEntity;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter @Setter

@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class BusinessCode extends BaseTimeEntity {
    @Id
    @GeneratedValue
    @Column(name = "business_code_id")
    private Long id;
    private String majorCode;
    private String majorName;
    private String middleCode;
    private String middleName;
    private String minorCode;
    private String minorName;
}

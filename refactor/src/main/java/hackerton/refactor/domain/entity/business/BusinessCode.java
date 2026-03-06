package hackerton.refactor.domain.entity.business;

import hackerton.refactor.domain.entity.base.BaseTimeEntity;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter @Setter
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

    public BusinessCode( String majorCode, String majorName, String middleCode, String middleName, String minorCode, String minorName) {
        this.majorCode = majorCode;
        this.majorName = majorName;
        this.middleCode = middleCode;
        this.middleName = middleName;
        this.minorCode = minorCode;
        this.minorName = minorName;
    }

    public BusinessCode() {
    }
}

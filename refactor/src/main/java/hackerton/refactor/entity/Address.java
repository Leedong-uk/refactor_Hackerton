package hackerton.refactor.entity;

import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.Setter;

@Embeddable
@Getter @Setter
public class Address {
    private String si;
    private String siGunGu;
    private String eupMyeonDong;
    private String detail;
}

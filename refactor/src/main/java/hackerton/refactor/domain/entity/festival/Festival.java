package hackerton.refactor.domain.entity.festival;

import hackerton.refactor.domain.entity.base.BaseEntity;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;


@Entity
@Getter @Setter
public class Festival extends BaseEntity {

    @Id
    @GeneratedValue
    @Column(name = "festival_id")
    private Long id;
    private String address;
    private String title;
    private String detailAddress;
    private LocalDate eventStartDate;
    private LocalDate eventEndDate;
    private String firstImage;
    private String tel;
    private String festivalTitle;
    @Lob
    private String overview;
    private Long contentId;
    private String telName;
    private double mapX;
    private double mapY;

    public Festival() {
    }
}

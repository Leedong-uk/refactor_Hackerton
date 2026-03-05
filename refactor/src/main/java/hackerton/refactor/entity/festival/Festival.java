package hackerton.refactor.entity.festival;

import hackerton.refactor.entity.base.BaseEntity;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;


@Entity
@Getter @Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Festival extends BaseEntity {

    @Id
    @GeneratedValue
    @Column(name = "festival_id")
    private Long id;
    private String address;
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


}

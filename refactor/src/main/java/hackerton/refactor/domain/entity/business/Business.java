package hackerton.refactor.domain.entity.business;

import hackerton.refactor.domain.dto.member.SignUpRequestDto;
import hackerton.refactor.domain.entity.Address;
import hackerton.refactor.domain.entity.base.BaseEntity;
import hackerton.refactor.domain.entity.member.Member;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.Date;

@Entity
@Getter @Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Business extends BaseEntity {
    @Id
    @GeneratedValue
    @Column(name = "business_id")
    private Long id;

    private String businessNumber;
    private String name;
    private LocalDate businessOpenDate;
    private String businessAddr;
    private String businessAddrDetail;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "business_code")
    private BusinessCode businessCode;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id",nullable = false, unique = true)
    private Member member;

    // == 편의 메서드 == //
    public static Business of (SignUpRequestDto dto) {
        Business business = new Business();
        business.businessNumber = dto.getBusinessNumber();
        business.name = dto.getBusinessNm();
        business.businessOpenDate = dto.getBusinessOpenDate();
        business.businessAddr = dto.getBusinessAddr();
        business.businessAddrDetail = dto.getBusinessAddrDetail();
        return business;
    }

    public void addMember(Member member) {
        this.member = member;
    }
}

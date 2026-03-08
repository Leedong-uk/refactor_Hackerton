package hackerton.refactor.domain.dto.member;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Data
public class MemberBusinessDto {
    private Long memberId;
    private String memberName;
    private Long businessId;
    private String businessName;
    private String businessNumber;
    private LocalDate businessOpenDate;
    private Long businessCodeId;
    private String businessAddr;
    private String businessAddrDetail;

    public MemberBusinessDto(Long memberId, String memberName,
                             Long businessId, String businessName, String businessNumber,
                             LocalDate businessOpenDate, Long businessCodeId,
                             String businessAddr, String businessAddrDetail) {
        this.memberId = memberId;
        this.memberName = memberName;
        this.businessId = businessId;
        this.businessName = businessName;
        this.businessNumber = businessNumber;
        this.businessOpenDate = businessOpenDate;
        this.businessCodeId = businessCodeId;
        this.businessAddr = businessAddr;
        this.businessAddrDetail = businessAddrDetail;
    }
}


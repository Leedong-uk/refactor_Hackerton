package hackerton.refactor.domain.dto.member;

import lombok.Data;

import java.time.LocalDate;

@Data
public class BusinessUpdateRequest {

    private String businessNumber; // 사업자 번호
    private String memberName; // 대표자 성명
    private String businessNm; // 상호명
    private LocalDate businessOpenDate;
    private String minorName;
    private String businessAddr;
    private String businessAddrDetail;

    public BusinessUpdateRequest(String businessNumber, String memberName, String businessNm, LocalDate businessOpenDate, String minorName, String businessAddr, String businessAddrDetail) {
        this.businessNumber = businessNumber;
        this.memberName = memberName;
        this.businessNm = businessNm;
        this.businessOpenDate = businessOpenDate;
        this.minorName = minorName;
        this.businessAddr = businessAddr;
        this.businessAddrDetail = businessAddrDetail;
    }
}

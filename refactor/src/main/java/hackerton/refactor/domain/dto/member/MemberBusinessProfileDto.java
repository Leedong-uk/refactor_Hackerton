package hackerton.refactor.domain.dto.member;


import hackerton.refactor.domain.entity.member.MemberBadge;
import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Data
public class MemberBusinessProfileDto {
    private Long memberId;
    private String memberName;
    private String email;
    private String businessName;
    private String businessNumber;
    private LocalDate businessOpenDate;
    private String businessAddr;
    private String businessAddrDetail;
    private String minorName;
    private MemberBadge badge;
    private String profileImageKey;


    public MemberBusinessProfileDto(String memberName, String email, String businessName, String businessNumber, LocalDate businessOpenDate, String businessAddr, String businessAddrDetail, String minorName, MemberBadge badge, String profileImageKey) {
        this.memberName = memberName;
        this.email = email;
        this.businessName = businessName;
        this.businessNumber = businessNumber;
        this.businessOpenDate = businessOpenDate;
        this.businessAddr = businessAddr;
        this.businessAddrDetail = businessAddrDetail;
        this.minorName = minorName;
        this.badge = badge;
        this.profileImageKey = profileImageKey;
    }
}
package hackerton.refactor.domain.dto.sos;

import hackerton.refactor.domain.entity.member.MemberBadge;
import hackerton.refactor.domain.entity.sos.SosType;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
public class SosDetailResponse {
    //member
    private MemberBadge badge;

    //profileImage
    private String profileImage;

    //business
    private String businessName;
    private String businessAddr;
    private String businessAddrDetail;
    //businessCode
    private String minorName;

    //sos
    private Long sosId;
    private String sosTitle;
    private SosType sosType;
    private String sosContent;
    private LocalDateTime expiresAt;
    private LocalDateTime createdAt;
    private List<String> imageKeys;


    public SosDetailResponse(MemberBadge badge, String profileImage, String businessName, String businessAddr, String businessAddrDetail, String minorName, Long sosId, String sosTitle, SosType sosType, String sosContent, LocalDateTime expiresAt, LocalDateTime createdAt) {
        this.badge = badge;
        this.profileImage = profileImage;
        this.businessName = businessName;
        this.businessAddr = businessAddr;
        this.businessAddrDetail = businessAddrDetail;
        this.minorName = minorName;
        this.sosId = sosId;
        this.sosTitle = sosTitle;
        this.sosType = sosType;
        this.sosContent = sosContent;
        this.expiresAt = expiresAt;
        this.createdAt = createdAt;
    }
}

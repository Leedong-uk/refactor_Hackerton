package hackerton.refactor.domain.dto.member;

import hackerton.refactor.domain.entity.member.MemberBadge;
import lombok.Data;

@Data
public class MemberInfoResponse {
    private String name;
    private String profileImage;
    private MemberBadge badge;
    private String businessName;
    private String minorName;

    public MemberInfoResponse(String name, String profileImage, MemberBadge badge, String businessName, String minorName) {
        this.name = name;
        this.profileImage = profileImage;
        this.badge = badge;
        this.businessName = businessName;
        this.minorName = minorName;
    }
}

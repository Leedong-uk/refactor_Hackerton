package hackerton.refactor.domain.dto.member;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.time.LocalDate;
import java.util.Date;

@Data
public class SignUpRequestDto {
    private String email;
    private String password;
    private String name;
    private String kakaoId;
    private String profileImageKey;

    private String businessNumber;
    private String businessNm;
    private LocalDate businessOpenDate;
    private String businessAddr;
    private String businessAddrDetail;
    private String minorName;

    public SignUpRequestDto() {
    }

    public SignUpRequestDto(String email, String password, String name, String kakaoId, String profileImageKey, String businessCode, String businessNm, LocalDate businessOpenDate, String businessAddr, String businessAddrDetail, String minorName) {
        this.email = email;
        this.password = password;
        this.name = name;
        this.kakaoId = kakaoId;
        this.profileImageKey = profileImageKey;
        this.businessNumber = businessCode;
        this.businessNm = businessNm;
        this.businessOpenDate = businessOpenDate;
        this.businessAddr = businessAddr;
        this.businessAddrDetail = businessAddrDetail;
        this.minorName = minorName;
    }
}

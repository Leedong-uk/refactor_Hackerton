package hackerton.refactor.domain.dto.announce;

import hackerton.refactor.domain.dto.document.DocumentCheckItemDto;
import hackerton.refactor.domain.entity.announce.Announce;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
@Builder
public class AnnounceDetailResponse {
    private String announceTitle;
    private String author;
    private String excInsttNm;
    private String description;
    private String lcategory;
    private LocalDateTime pubDate;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
    private String targetName;
    private Integer viewNum;
    private String filePathName;
    private String fileName;
    private String howToRegister;
    private String callCompany;
    private String printFilePathName;
    private String printFileName;
    private List<DocumentCheckItemDto> checklist;

    public static AnnounceDetailResponse of(Announce announce) {
        return AnnounceDetailResponse.builder()
                .announceTitle(announce.getTitle())
                .author(announce.getAuthor())
                .excInsttNm(announce.getExcInsttNm())
                .description(announce.getDescription())
                .lcategory(announce.getLcategory())
                .pubDate(announce.getPubDate())
                .startDate(announce.getReqstStartDate())
                .endDate(announce.getReqstEndDate())
                .targetName(announce.getTargetName())
                .viewNum(announce.getViewNum())
                .filePathName(announce.getFileName())
                .fileName(announce.getFileName())
                .howToRegister(announce.getHowToRegister())
                .callCompany(announce.getCallCompany())
                .printFilePathName(announce.getPrintFilePath())
                .printFileName(announce.getPrintFileName())
                .checklist(null)
                .build();
    }
}

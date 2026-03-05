package hackerton.refactor.domain.entity.announce;

import hackerton.refactor.domain.entity.base.BaseEntity;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter @Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Announce extends BaseEntity {
    @Id
    @GeneratedValue
    @Column(name = "announce_id")
    private Long id;
    private String title;
    private String author;
    private String excInsttNm;
    private String description;
    private String lcategory;
    private LocalDateTime pubDate;
    private String targetName;
    private int viewNum;
    private String printFilePath;
    private String printFileName;
    private String howToRegister;
    private String callCompany;
    private LocalDateTime reqstStartDate;
    private LocalDateTime reqstEndDate;
    private String filePath;
    private String fileName;

    @OneToMany(mappedBy = "announce", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Document> documents = new ArrayList<>();

    public void addDocument(Document document) {
        documents.add(document);
        document.setAnnounce(this);
    }
}

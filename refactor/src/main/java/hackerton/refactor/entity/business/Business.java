package hackerton.refactor.entity.business;

import hackerton.refactor.entity.Address;
import hackerton.refactor.entity.base.BaseEntity;
import hackerton.refactor.entity.member.Member;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter @Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Business extends BaseEntity {
    @Id
    @GeneratedValue
    @Column(name = "business_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "business_code_id")
    private BusinessCode businessCode;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member member;

    private String name;
    @Embedded
    private Address address;


}

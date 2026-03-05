package hackerton.refactor.domain.entity.business;

import hackerton.refactor.domain.entity.Address;
import hackerton.refactor.domain.entity.base.BaseEntity;
import hackerton.refactor.domain.entity.member.Member;
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
    @JoinColumn(name = "business_code_id",nullable = false)
    private BusinessCode businessCode;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id",nullable = false, unique = true)
    private Member member;

    private String name;
    @Embedded
    private Address address;


}

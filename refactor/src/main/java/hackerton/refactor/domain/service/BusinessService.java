package hackerton.refactor.domain.service;

import hackerton.refactor.domain.dto.member.BusinessUpdateRequest;
import hackerton.refactor.domain.dto.member.MemberBusinessDto;
import hackerton.refactor.domain.entity.business.Business;
import hackerton.refactor.domain.entity.business.BusinessCode;
import hackerton.refactor.domain.entity.member.Member;
import hackerton.refactor.domain.repository.business.BusinessCodeRepository;
import hackerton.refactor.domain.repository.business.BusinessRepository;
import hackerton.refactor.domain.repository.member.MemberRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional(readOnly = true)
@Service
@Slf4j
@RequiredArgsConstructor
public class BusinessService {

    private final BusinessRepository businessRepository;
    private final BusinessCodeRepository businessCodeRepository;
    private final MemberRepository memberRepository;

    @Transactional
    public void updateBusiness(Long memberId, BusinessUpdateRequest request) {

        BusinessCode newCode = businessCodeRepository.findBusinessCodeByMinorName(request.getMinorName());


        Business business = businessRepository.findBusinessWithMember(memberId);

        business.setBusinessNumber(request.getBusinessNumber());
        business.setName(request.getBusinessNm());
        business.setBusinessOpenDate(request.getBusinessOpenDate());
        business.setBusinessCode(newCode);
        business.setBusinessAddr(request.getBusinessAddr());
        business.setBusinessAddrDetail(request.getBusinessAddrDetail());
        business.getMember().setName(request.getMemberName());


    }

}

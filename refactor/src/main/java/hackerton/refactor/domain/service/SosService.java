package hackerton.refactor.domain.service;

import hackerton.refactor.domain.dto.SosCreateRequest;
import hackerton.refactor.domain.entity.member.Member;
import hackerton.refactor.domain.entity.sos.Sos;
import hackerton.refactor.domain.entity.sos.SosImage;
import hackerton.refactor.domain.repository.member.MemberRepository;
import hackerton.refactor.domain.repository.sos.SosImageRepository;
import hackerton.refactor.domain.repository.sos.SosRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
@Slf4j
public class SosService {

    private final SosRepository sosRepository;
    private final MemberRepository memberRepository;

    @Transactional
    public void createSos(Long memberId , SosCreateRequest request) {
        Member member = memberRepository.getReferenceById(memberId);

        Sos sos = Sos.of(request);
        sos.setMember(member);

        for (int i = 0; i < request.getImages().size(); i++) {
            SosImage image = new SosImage(request.getImages().get(i));
            image.setSortOrder(i);
            sos.addImage(image);
        }
        sosRepository.save(sos);
    }
}

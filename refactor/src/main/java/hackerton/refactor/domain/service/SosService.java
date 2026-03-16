package hackerton.refactor.domain.service;

import hackerton.refactor.domain.dto.sos.SosCreateRequest;
import hackerton.refactor.domain.dto.sos.SosUpdateRequest;
import hackerton.refactor.domain.entity.member.Member;
import hackerton.refactor.domain.entity.sos.Sos;
import hackerton.refactor.domain.entity.sos.SosImage;
import hackerton.refactor.domain.repository.member.MemberRepository;
import hackerton.refactor.domain.repository.sos.SosImageRepository;
import hackerton.refactor.domain.repository.sos.SosRepository;
import jakarta.persistence.EntityManager;
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
    private final SosImageRepository sosImageRepository;


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

    @Transactional
    public void updateSos(Long memberId, Long sosId, SosUpdateRequest request) {
        Sos sos = sosRepository.findById(sosId)
                .orElseThrow(() -> new RuntimeException("SOS 없음"));

        if (!sos.getMember().getId().equals(memberId)) {
            throw new RuntimeException("수정 권한 없음");
        }

        sos.updateInfo(request.getTitle(), request.getType(), request.getContent(), request.getExpiredAt());
        sosImageRepository.deleteSosBulk(sosId);
        sos.getImages().clear();

        for (int i = 0; i < request.getImages().size(); i++) {
            SosImage image = new SosImage(request.getImages().get(i));
            image.setSortOrder(i);
            sos.addImage(image);
        }
    }


    @Transactional
    public void deleteSos(Long memberId , Long sosId) {
        Sos sos = sosRepository.findById(sosId)
                .orElseThrow();

        if (!sos.getMember().getId().equals(memberId)) {
            throw new RuntimeException("삭제 권한 없음");
        }

        sosImageRepository.deleteAllBySosId(sosId);
        sosImageRepository.deleteSosBulk(sosId);
    }
}

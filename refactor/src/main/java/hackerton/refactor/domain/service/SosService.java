package hackerton.refactor.domain.service;

import hackerton.refactor.domain.dto.SosCreateRequest;
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

    private SosRepository sosRepository;

    public void createSos(Long memberId , SosCreateRequest request) {

    }
}

package hackerton.refactor.web.controller.checklist;

import hackerton.refactor.domain.service.AnnounceService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/checklist")
public class CheckListController {

    private final AnnounceService announceService;


}

package hackerton.refactor.web.controller.checklist;

import hackerton.refactor.domain.dto.document.DocumentInsertRequest;
import hackerton.refactor.domain.service.AnnounceService;
import hackerton.refactor.domain.service.MemberDocumentCheckService;
import hackerton.refactor.general.security.userdetail.CustomUser;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/checklist")
public class CheckListController {

    private final AnnounceService announceService;
    private final MemberDocumentCheckService memberDocumentCheckService;

    @PostMapping("/{announceId}")
    public void addFavorite(@AuthenticationPrincipal CustomUser user,
                            @PathVariable Long announceId,
                            @RequestBody List<DocumentInsertRequest> requests) {
        memberDocumentCheckService.saveChecklist(user.getMemberId(),announceId,requests);
    }


}

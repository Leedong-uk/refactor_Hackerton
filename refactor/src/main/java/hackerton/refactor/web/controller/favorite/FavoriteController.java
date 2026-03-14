package hackerton.refactor.web.controller.favorite;

import hackerton.refactor.domain.dto.document.DocumentCheckItemDto;
import hackerton.refactor.domain.dto.document.DocumentInsertRequest;
import hackerton.refactor.domain.service.MemberDocumentCheckService;
import hackerton.refactor.general.response.ApiSuccess;
import hackerton.refactor.general.security.userdetail.CustomUser;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class FavoriteController {

    private final MemberDocumentCheckService memberDocumentCheckService;

    @GetMapping("/test/{announceId}")
    @ApiSuccess()
    public List<DocumentCheckItemDto> test (@AuthenticationPrincipal CustomUser user, @PathVariable Long announceId) {
        return memberDocumentCheckService.getAllChecklist(user.getMemberId(), announceId);
    }


}

package hackerton.refactor.web.controller.favorite;

import hackerton.refactor.domain.dto.document.DocumentCheckItemDto;
import hackerton.refactor.domain.dto.favorite.FavoriteResponse;
import hackerton.refactor.domain.service.FavoriteService;
import hackerton.refactor.domain.service.MemberDocumentCheckService;
import hackerton.refactor.general.response.ApiSuccess;
import hackerton.refactor.general.security.userdetail.CustomUser;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class FavoriteController {

    private final MemberDocumentCheckService memberDocumentCheckService;
    private final FavoriteService favoriteService;

    @GetMapping("/test/{announceId}")
    @ApiSuccess()
    public List<DocumentCheckItemDto> test (@AuthenticationPrincipal CustomUser user, @PathVariable Long announceId) {
        return memberDocumentCheckService.getAllChecklist(user.getMemberId(), announceId);
    }

    //favorite 추가
    @PostMapping("/favorite/{announceId}")
    @ApiSuccess(message = "favorite.add")
    public void addFavorite(@AuthenticationPrincipal CustomUser user, @PathVariable Long announceId) {
        favoriteService.addFavorite(announceId,user.getMemberId());
    }

    //favorite 삭제
    @DeleteMapping("/favorite/{announceId}")
    @ApiSuccess(message="favorite.delete")
    public void removeFavorite(@AuthenticationPrincipal CustomUser user, @PathVariable Long announceId) {
        favoriteService.removeFavorite(announceId,user.getMemberId());
    }

    //favorite list 가져오기
    @GetMapping("/favorite")
    @ApiSuccess(message = "favorite.list")
    public List<FavoriteResponse> getFavorites(@AuthenticationPrincipal CustomUser user , Pageable pageable) {
        return favoriteService.getFavorites(user.getMemberId(), pageable);
    }


}

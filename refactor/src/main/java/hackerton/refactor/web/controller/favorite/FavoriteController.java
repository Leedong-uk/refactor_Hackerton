package hackerton.refactor.web.controller.favorite;

import hackerton.refactor.domain.service.FavoriteService;
import hackerton.refactor.general.response.ApiSuccess;
import hackerton.refactor.general.security.userdetail.CustomUser;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class FavoriteController {

    private final FavoriteService favoriteService;

    @PostMapping("/favorite/{announceId}")
    @ApiSuccess(message = "favorite.add")
    public void addFavorite(@AuthenticationPrincipal CustomUser user, @PathVariable Long announceId) {
        favoriteService.addFavorite(announceId,user.getMemberId());
    }

    @DeleteMapping("/favorite/{announceId}")
    @ApiSuccess(message="favorite.delete")
    public void removeFavorite(@AuthenticationPrincipal CustomUser user, @PathVariable Long announceId) {
        favoriteService.removeFavorite(announceId,user.getMemberId());
    }

}

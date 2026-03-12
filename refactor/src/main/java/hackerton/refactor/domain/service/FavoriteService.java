package hackerton.refactor.domain.service;


import hackerton.refactor.domain.dto.favorite.FavoriteResponse;
import hackerton.refactor.domain.entity.announce.Announce;
import hackerton.refactor.domain.entity.member.Member;
import hackerton.refactor.domain.entity.member.MemberFavorite;
import hackerton.refactor.domain.repository.announce.AnnounceRepository;
import hackerton.refactor.domain.repository.favorite.FavoriteRepository;

import hackerton.refactor.domain.repository.member.MemberRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
@Slf4j
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class FavoriteService {
    private final FavoriteRepository favoriteRepository;
    private final MemberRepository memberRepository;
    private final AnnounceRepository announceRepository;

    @Transactional
    public void addFavorite(Long announceId , Long memberId) {
        Member member = memberRepository.getReferenceById(memberId);
        Announce announce = announceRepository.getReferenceById(announceId);

        MemberFavorite memberFavorite = new MemberFavorite();
        memberFavorite.setMember(member);
        memberFavorite.setAnnounce(announce);

        favoriteRepository.save(memberFavorite);
    }

    @Transactional
    public void removeFavorite(Long announceId, Long memberId) {
        favoriteRepository.deleteByAnnounceIdAndMemberId(announceId,memberId);
    }

    public List<FavoriteResponse> getFavorites(Long memberId,Pageable pageable) {
        Slice<FavoriteResponse> favoritesByMemberId = favoriteRepository.findFavoritesByMemberId(memberId, pageable);
        return favoritesByMemberId.getContent();
    }

}

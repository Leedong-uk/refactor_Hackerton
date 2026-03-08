package hackerton.refactor.general.security.userdetail;

import hackerton.refactor.domain.entity.auth.AuthStatus;
import hackerton.refactor.domain.entity.member.Member;
import hackerton.refactor.domain.repository.auth.AuthRepository;
import hackerton.refactor.domain.repository.member.MemberRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class CustomUserDetailsService implements UserDetailsService {
    private final MemberRepository memberRepository;
    private final AuthRepository authRepository;

    @Override
    @Transactional(readOnly = true)
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {

        Member member = memberRepository.findMemberByEmail(email);

        if (member == null)
            throw new UsernameNotFoundException("유저를 찾을 수 없습니다.");
        List<AuthStatus> findAuthList = authRepository.findStatusesByMemberId(member.getId());

        if (findAuthList.isEmpty())
            throw new UsernameNotFoundException("권한이 없는 사용자입니다.");
        LoginMemberDto dto = LoginMemberDto.of(member, findAuthList);

        return new CustomUser(dto);
    }
}

package hackerton.refactor.general.security.userdetail;

import hackerton.refactor.domain.entity.member.Member;
import hackerton.refactor.domain.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Slf4j
public class CustomUserDetailsService implements UserDetailsService {
    private final MemberRepository memberRepository;

    @Override
    @Transactional(readOnly = true)
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Member member = memberRepository.findMemberByEmail(email);


        if (member == null) {
            throw new UsernameNotFoundException("유저를 찾을 수 없습니다.");
        }
        CustomUserRequest dto = CustomUserRequest.of(member);

        return new CustomUser(dto);

    }
}

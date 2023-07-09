package project.toco.service;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import project.toco.dto.MemberDto;
import project.toco.entity.LoginUser;
import project.toco.repository.MemberRepository;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class AuthService implements UserDetailsService {
  private final MemberRepository memberRepository;

  @Override
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    MemberDto dto = memberRepository.findByEmailToDto(username);
    return LoginUser.create(dto.getUuid(), dto.getEmail(), dto.getPassword(), dto.getRole());
  }
}

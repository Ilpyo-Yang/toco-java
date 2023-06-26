package project.toco.service;

import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import project.toco.dto.form.SignupForm;
import project.toco.entity.Member;
import project.toco.repository.MemberRepository;
import project.toco.security.TokenProvider;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class MemberService implements UserDetailsService {
  private final AuthenticationManagerBuilder authenticationManagerBuilder;
  private final TokenProvider tokenProvider;
  private final PasswordEncoder passwordEncoder;

  private final MemberRepository memberRepository;

  @Override
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    return memberRepository.findById(username)
        .map(this::createUserDetails)
        .orElseThrow(() -> new UsernameNotFoundException("해당하는 유저를 찾을 수 없습니다."));
  }

  private UserDetails createUserDetails(Member member) {
    return org.springframework.security.core.userdetails.User.builder()
        .username(member.getUsername())
        .password(passwordEncoder.encode(member.getPassword()))
        .roles(member.getRole())
        .build();
  }

  public Member findById(String uuid){ return memberRepository.findById(uuid).get(); }

  public List<Member> findAll(){
    return memberRepository.findAll();
  }

  @Transactional
  public String create(SignupForm form){
    Member member = Member.createMember(form.getName(), form.getEmail(), passwordEncoder.encode(form.getPassword()), "MEMBER");
    memberRepository.save(member);
    return member.getUuid();
  }

  @Transactional
  public String update(Member m){
    Member member = memberRepository.save(m);
    return member.getUuid();
  }

  public String login(String email, String password) {
    UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(memberRepository.findByEmail(email).getUuid(), password);
    Authentication authentication = authenticationManagerBuilder.getObject().authenticate(authenticationToken);
    return tokenProvider.generateToken(authentication);
  }

  public String existEmail(String email) {
    return memberRepository.findByEmail(email)==null? "" : memberRepository.findByEmail(email).getUuid();
  }
}

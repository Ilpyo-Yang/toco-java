package project.toco.service;

import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
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
  private final TokenProvider tokenProvider;
  private final PasswordEncoder passwordEncoder;
  private final MemberRepository memberRepository;

  @Override
  public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
    Member member = memberRepository.findByEmail(email);
    return userDetailsBuilder(member);
  }

  private UserDetails createUserDetails(Member member) {
    return org.springframework.security.core.userdetails.User.builder()
        .username(member.getEmail())
        .password(passwordEncoder.encode(member.getPassword()))
        .roles(member.getRole())
        .build();
  }

  @Transactional
  public String create(SignupForm form){
    Member member = Member.createMember(form.getName(), form.getEmail(), passwordEncoder.encode(form.getPassword()), "MEMBER");
    memberRepository.save(member);
    UserDetails user = User.withUsername(member.getEmail())
                          .password(member.getPassword())
                          .roles(member.getRole())
                          .build();
    doAutoLogin(tokenProvider.generateToken(user));
    return member.getUuid();
  }

  @Transactional
  public String update(Member m){
    Member member = memberRepository.save(m);
    return member.getUuid();
  }

  public String login(String email, String password) {
    Member member = memberRepository.findByEmail(email);
    UserDetails userDetails = userDetailsBuilder(member);
    if (member == null)
      return "";
    if (!passwordEncoder.matches(password, member.getPassword()))
      return "";
    String token = tokenProvider.generateToken(userDetails);
    doAutoLogin(token);
    return token;
  }

  private void doAutoLogin(String token) {
    Authentication authentication = tokenProvider.getAuthentication(token);
    SecurityContextHolder.getContext().setAuthentication(authentication);
  }

  public String existEmail(String email) {
    return memberRepository.findByEmailToDto(email)==null? "" : memberRepository.findByEmailToDto(email).getUuid();
  }

  public UserDetails userDetailsBuilder(Member member){
    return User.withUsername(member.getEmail())
        .password(member.getPassword())
        .roles(member.getRole())
        .build();
  }

  /* test */
  public Member findById(String uuid) throws NoSuchFieldException {
    return memberRepository.findById(uuid).orElseThrow(() -> new NoSuchFieldException("일치하는 사용자가 없습니다."));
  }
  public Member findByEmail(String email){ return memberRepository.findByEmail(email); }
  public List<Member> findAll(){
    return memberRepository.findAll();
  }

}

package project.toco.service;

import java.util.ArrayList;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.transaction.annotation.Transactional;
import project.toco.dto.MemberDto;
import project.toco.dto.form.SignupForm;
import project.toco.entity.LoginUser;
import project.toco.entity.Member;
import project.toco.repository.MemberRepository;

@SpringBootTest
@Transactional
class MemberServiceTest {
  @Autowired
  MemberRepository memberRepository;

  public BCryptPasswordEncoder passwordEncoder() {
    return new BCryptPasswordEncoder(16);
  }

  @Test
  void create() {
    SignupForm form = new SignupForm("testt", "testt@gmail.com", "1234", "TEACHER");
    Member member = Member.createMember(form.getName(), form.getEmail(), passwordEncoder().encode(form.getPassword()), form.getRole(), new ArrayList<>());
    memberRepository.save(member);
    assert member.getUuid().equals(memberRepository.findByEmail(member.getEmail()));
  }

  // 로직 업데이트 예정
  @Test
  void update() {
  }

  // 로직 업데이트 예정
  @Test
  void login() {
  }

  @Test
  void existEmail() {
    String email = "test@gmail.com";
    MemberDto memberDto = memberRepository.findByEmailToDto(email);
    assert email.equals(memberDto.getEmail());
  }

  @Test
  void userDetailsBuilder() {
    Member member = memberRepository.findAll().get(0);
    LoginUser user = LoginUser.create(member.getUuid(), member.getName(), member.getEmail(), member.getPassword(), member.getRole());
    assert user!=null;
    assert member.getName().equals(user.getName());
  }


  // spring data
  @Test
  void findById() {
  }

  // spring data
  @Test
  void findByEmail() {
  }

  // spring data
  @Test
  void findAll() {
  }
}
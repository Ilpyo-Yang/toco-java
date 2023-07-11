package project.toco.service;

import java.util.ArrayList;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.transaction.annotation.Transactional;
import project.toco.dto.MemberDto;
import project.toco.entity.LoginUser;
import project.toco.entity.Member;
import project.toco.repository.MemberRepository;

@SpringBootTest
@Transactional
public class AuthServiceTest {
  @Autowired
  MemberRepository memberRepository;

  public BCryptPasswordEncoder passwordEncoder() {
    return new BCryptPasswordEncoder(16);
  }

  @Test
  public void loadUserByUsername() {
    String email = "authTest@gmail.com";
    memberRepository.save(Member.createMember("authTest", email,
                                    passwordEncoder().encode("1234"),
                                    "STUDENT",
                                    new ArrayList<>()));
    MemberDto dto = memberRepository.findByEmailToDto(email);
    LoginUser user = LoginUser.create(dto.getUuid(), dto.getName(), dto.getEmail(), dto.getPassword(), dto.getRole());
    assert user.getUsername().equals(dto.getEmail());
  }
}
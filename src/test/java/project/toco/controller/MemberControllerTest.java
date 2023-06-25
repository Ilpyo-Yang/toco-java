package project.toco.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;
import project.toco.dto.form.SignupForm;
import project.toco.service.MemberService;

@SpringBootTest
@Transactional
class MemberControllerTest {
  @Autowired
  MemberService memberService;

  @Test
  @Rollback(false)
  public void signupTest() {
    SignupForm form = new SignupForm("test17", "test17@gmail.com", "1234", "MEMBER");
    String uuid = memberService.create(form);
    assert memberService.findById(uuid).getName().equals("test17");
  }

  @Test
  public void loginTest(){
    System.out.println(memberService.login("rosie@gmail.com","1234"));
    assert !memberService.login("rosie@gmail.com","1234").isEmpty();
  }

}
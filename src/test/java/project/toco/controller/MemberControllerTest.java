package project.toco.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;
import project.toco.dto.form.SignupForm;
import project.toco.entity.Member;
import project.toco.service.MemberService;

@SpringBootTest
@Transactional
class MemberControllerTest {
  @Autowired
  MemberService memberService;
  @Test
  public void saveMemberTest(){
    SignupForm form = new SignupForm("rosie","rosie@gmail.com","1234","USER");
    String uuid = memberService.create(form);
    assert memberService.findById(uuid).getName().equals("rosie");
  }
}
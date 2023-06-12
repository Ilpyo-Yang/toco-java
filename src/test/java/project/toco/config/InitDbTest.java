package project.toco.config;

import java.util.List;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;
import project.toco.dto.EducationTypeDto;
import project.toco.dto.form.SignupForm;
import project.toco.entity.Education;
import project.toco.entity.EducationContent;
import project.toco.entity.Member;
import project.toco.entity.Status;
import project.toco.service.EducationService;
import project.toco.service.EducationTypeService;
import project.toco.service.MemberService;
import project.toco.service.ProgressService;

@SpringBootTest
public class InitDbTest {
  @Autowired
  MemberService memberService;
  @Autowired
  ProgressService progressService;
  @Autowired
  EducationService educationService;
  @Autowired
  EducationTypeService educationTypeService;

  @Test
  @Transactional
  @Rollback(false)
  public void intDb(){
//    educationTypeService.create("CS", "CS");
//    educationTypeService.create("CS", "Architecture");
//    educationTypeService.create("Backend", "Java");
//    educationTypeService.create("Backend", "Python");
    List<EducationTypeDto> typeList = educationTypeService.findTypesToDto();
    assert typeList.size()==0;

    SignupForm form = new SignupForm("rosie","rosie@gmail.com","1234", "USER");
    String uuid = memberService.create(form);
    Member member = memberService.findById(uuid);
    assert member.equals("rosie");

    EducationContent educationContent = EducationContent.createEducationContents(1, "학습1", "오늘은 학습 1을 학습합니다.");
    EducationContent educationContent2 = EducationContent.createEducationContents(2, "학습2", "오늘은 학습 2을 학습합니다.");
    List<EducationContent> list = List.of(educationContent, educationContent2);
    Education education = Education.createEducation("테스트 언어", "테스트 언어를 배워볼까요?", typeList.get(0).getUuid(), list);
    assert education.getType()==typeList.get(0).getUuid();

    String progress_uuid = progressService.create(Status.Finished, member.getUuid(), education.getEducationContents().get(0).getUuid());
    assert progressService.findById(progress_uuid).getStatus().equals(Status.Finished);
  }
}

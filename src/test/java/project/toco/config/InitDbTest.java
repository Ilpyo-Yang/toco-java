package project.toco.config;

import java.util.List;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;
import project.toco.dto.EducationContentDto;
import project.toco.dto.EducationDto;
import project.toco.dto.EducationTypeDto;
import project.toco.dto.form.SignupForm;
import project.toco.entity.Education;
import project.toco.entity.Member;
import project.toco.entity.Status;
import project.toco.service.EducationService;
import project.toco.service.EducationTypeService;
import project.toco.service.MemberService;
import project.toco.service.ProgressService;

@SpringBootTest
@Transactional
@Rollback(false)
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
  public void intTypeDb(){
    educationTypeService.create("CS", "CS");
    educationTypeService.create("CS", "Architecture");
    educationTypeService.create("Backend", "Java");
    educationTypeService.create("Backend", "Python");
    List<EducationTypeDto> typeList = educationTypeService.findTypesToDto();
    assert typeList.size()==4;
  }

  @Test
  public void intMemberDb() {
    SignupForm form = new SignupForm("rosie", "rosie@gmail.com", "1234", "USER");
    String uuid = memberService.create(form);
    Member member = memberService.findById(uuid);
    assert member.getName().equals("rosie");
  }

  @Test
  public void intEduDb(){
    List<EducationTypeDto> typeList = educationTypeService.findTypesToDto();

    EducationContentDto educationContentDto = new EducationContentDto(null, 1, "학습1", "오늘은 학습 1을 학습합니다.", null);
    EducationContentDto educationContentDto2 = new EducationContentDto(null, 2, "학습2", "오늘은 학습 2을 학습합니다.", null);
    List<EducationContentDto> list = List.of(educationContentDto, educationContentDto2);
    EducationDto educationDto = new EducationDto(null, "주제", "자바를 배워봅시다", 0, 0, typeList.get(0).getUuid(), null, null);
    String education_uuid = educationService.create(educationDto, list);
    assert educationService.findById(education_uuid).getType().equals(typeList.get(0).getUuid());
  }

  @Test
  public void intProgressDb(){
    List<EducationTypeDto> typeList = educationTypeService.findTypesToDto();
    Member member = memberService.findAll().get(0);
    Education education = educationService.findAll().get(0);

    String progress_uuid = progressService.create(Status.Finished, member.getUuid(), education.getEducationContents().get(0).getUuid());
    assert progressService.findById(progress_uuid).getStatus().equals(Status.Finished);
  }
}

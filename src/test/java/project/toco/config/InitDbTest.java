package project.toco.config;

import java.time.LocalDate;
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
import project.toco.entity.EducationScore;
import project.toco.entity.Level;
import project.toco.entity.Member;
import project.toco.entity.Status;
import project.toco.service.EducationScoreService;
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
  @Autowired
  EducationScoreService educationScoreService;

  @Test
  public void intTypeDb(){
    educationTypeService.create("CS", "CS");
    educationTypeService.create("CS", "Architecture");
    educationTypeService.create("Backend", "Java");
    educationTypeService.create("Backend", "Python");
    educationTypeService.create("Frontend", "React");
    List<EducationTypeDto> typeList = educationTypeService.findTypesToDto();
    assert typeList.size()==4;
  }

  @Test
  public void intMemberDb() {
    SignupForm form = new SignupForm("rosie", "rosie@gmail.com", "1234", "MEMBER");
    String uuid = memberService.create(form);
    Member member = memberService.findById(uuid);
    assert member.getName().equals("rosie");

    form = new SignupForm("john", "john@gmail.com", "1234", "MEMBER");
    uuid = memberService.create(form);
  }

  @Test
  public void intEduDb(){
    List<EducationTypeDto> typeList = educationTypeService.findTypesToDto();

    EducationContentDto educationContentDto = new EducationContentDto(null, 0,
        "자바 개발 시작하기",
        "오늘은 자바에 대해 알아보는 시간입니다. 자바라는 언어는 어떤 언어이고 기본 설치부터 공식문서를 보는 법을 알아봅니다.",
        "1. 자바란? 자바의 역사와 다른 언어와의 차이점을 알아봅니다. 자바는 또 어떤 특성을 가진 언어인가요? \n "
            + "2. 자바 공식문서를 들어가볼까요? 공식 사이트에서 java 소개와 특성에 대해 알아봅니다. \n "
            + "3. 자바를 시작해봅시다. 기본 설치하는 방법을 알아보고 intellij에 설치합니다. 버전은 17 이상을 이용해주세요."
            + "4. 버전별로 어떤 차이가 있는지 알아볼까요?",
        null);
    EducationContentDto educationContentDto1 = new EducationContentDto(null, 1,
        "자바 기본문법",
        "자바 기본문법을 익히는 시간입니다. 자바 언어를 사용해보고 어떤 기능들을 제공하고 있는지 어떻게 사용하면 좋을지 알아봅니다.",
        "1. 변수와 리터럴과 인터프린트 언어, 컴파일러 언어란 무엇인지 알아봅시다. \n"
            + "2. 자바의 타입은 어떤 종류가 있을까요? 실제로 어떨 때 어떤 타입을 사용하는게 좋을지 찾아보세요. \n"
            + "3. 연산자 종류에 대해 알아봅니다. \n"
            + "4. 조건문과 반복문에 대해 알아봅니다.",
        null);
    EducationContentDto educationContentDto2 = new EducationContentDto(null, 2,
        "객체지향 문법",
        "자바는 객체지향 언어입니다. 객체는 무엇이고 객체지향은 어떤 의미일까요? 왜 객체지향 언어를 개발했는지 알아보는 시간입니다.",
        "1. 객체 그리고 객체지향 문법이란? \n"
            + "2. 객체지향 언어의 종류는 어떤게 있을까요? \n"
            + "3. 실제 자바 코드에서 객체지향 언어를 보여주는 예시를 찾아봅시다. \n"
            + "4. 객체 지향 프로그래밍이란 무엇이고 그 특징을 알아봅니다.",
        null);
    List<EducationContentDto> list = List.of(educationContentDto, educationContentDto1, educationContentDto2);

    EducationDto educationDto = new EducationDto(null, "초보를 위한 Java",
        "Java를 처음 입문하는 사람들에게 스스로 학습할 수 있는 방법을 알려드립니다.",
        0, 0, 0, "67373590-8373-4697-92a0-23831f924b87", Level.Basic, null, null);
    String education_uuid = educationService.create(educationDto, list);
    assert educationService.findById(education_uuid).getType().equals(typeList.get(0).getUuid());
  }

  @Test
  public void intProgressDb(){
    Member member = memberService.findAll().get(0);
    Education education = educationService.findAll().get(0);
    String progress_uuid = progressService.create(LocalDate.parse("2023-06-20"), "mon,sat", Status.Finished, member.getUuid(), education.getEducationContents().get(0).getUuid());
    assert progressService.findById(progress_uuid).getStatus().equals(Status.Finished);
  }

  @Test
  public void intEduScoreDb() {
    String member_uuid = memberService.findAll().get(0).getUuid();
    Education education = educationService.findAll().get(0);
    EducationScore educationScore = educationScoreService.create(EducationScore.createEducationScore(member_uuid, 2, education));
    assert educationScore.getUuid().equals(educationScoreService.findById(educationScore.getUuid()).getUuid());
  }
}

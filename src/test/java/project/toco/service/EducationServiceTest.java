package project.toco.service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;
import project.toco.dto.EducationDto;
import project.toco.dto.condition.EduCondition;
import project.toco.entity.Education;
import project.toco.entity.EducationType;
import project.toco.entity.Level;
import project.toco.repository.EducationContentRepository;
import project.toco.repository.EducationRepository;
import project.toco.repository.EducationTypeRepository;

@SpringBootTest
@Transactional
class EducationServiceTest {
  @Autowired
  EducationRepository educationRepository;
  @Autowired
  EducationContentRepository educationContentRepository;
  @Autowired
  EducationTypeRepository educationTypeRepository;

  @Test
  void findOneEduToDto() {
    Education education = educationRepository.findAll().get(0);
    EducationDto educationDto = educationRepository.findOneEduToDto(education.getUuid());
    assert education.getPeriod() == educationDto.getPeriod();
  }

  @Test
  void findAllToDto() {
    List<Education> list = educationRepository.findAll();
    List<EducationDto> educationDtoList = educationRepository.findAllToDto();
    assert list.size() == educationDtoList.size();
  }

  @Test
  void findAllToDtoWithCondition() {
    EduCondition eduCondition = new EduCondition();
    eduCondition.setLevel(Level.Challenge);
    List<EducationDto> educationDtoList = educationRepository.findAllToDtoWithCondition(eduCondition);
    assert Level.Challenge.equals(educationDtoList.get(0).getLevel());
  }

  // spring data
  @Test
  void findById() {
  }

  // spring data
  @Test
  void findAll() {
  }

  // spring data
  @Test
  void findAllEduNames() {
  }

  @Test
  void create() {
    EducationType educationType = educationTypeRepository.findAll().get(0);
    Education education = Education.createEducation("education 생성 test",
                                "education 생성 test intro",
                                educationType.getUuid(),
                                Level.Challenge,
                                new ArrayList<>());
    educationRepository.save(education);
    assert education.getName().equals(educationRepository.findById(education.getUuid()).get().getName());
  }


  // 로직 수정 예정
  @Test
  void update() {

  }

  @Test
  void mapper() {
    // 점수 있는 education 있다는 전제하
    EducationDto educationDto = new EducationDto();
    educationDto.setScore(5);
    EducationDto educationDto1 = new EducationDto();
    educationDto1.setScore(2);
    EducationDto educationDto2 = new EducationDto();
    educationDto2.setScore(5);
    EducationDto educationDto3 = new EducationDto();
    educationDto3.setScore(5);

    List<EducationDto> educationDtoList = List.of(educationDto, educationDto1, educationDto2, educationDto3);
    List<EducationDto> sorted_educationDtoList = educationDtoList.stream().sorted(Comparator.comparing(EducationDto::getScore).reversed())
                      .limit(3)
                      .collect(Collectors.toList());

    for(EducationDto dto: sorted_educationDtoList){
      if(dto.getScore()!=5) assert false;
    }
    assert true;
  }

  @Test
  void getTopThree() {
  }
}
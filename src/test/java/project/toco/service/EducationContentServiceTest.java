package project.toco.service;

import java.util.List;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;
import project.toco.dto.EducationContentDto;
import project.toco.entity.Education;
import project.toco.entity.EducationContent;
import project.toco.repository.EducationContentRepository;
import project.toco.repository.EducationRepository;

@SpringBootTest
@Transactional
public class EducationContentServiceTest {
  @Autowired
  EducationContentRepository educationContentRepository;
  @Autowired
  EducationRepository educationRepository;

  @Test
  public void getNextUuid(){
    String uuid = educationContentRepository.findAll().get(0).getUuid();
    EducationContent current = educationContentRepository.findById(uuid).get();
    String nextUuid = educationContentRepository.getNextUuid(current.getChapter()+1, current.getEducation());
    EducationContent nextOne = educationContentRepository.findById(nextUuid).get();
    assert current.getChapter()+1 == nextOne.getChapter();
  }

  @Test
  public void findAllToDto(){
    String education_uuid = educationRepository.findAll().get(0).getUuid();
    Education education = educationRepository.findById(education_uuid).get();
    List<EducationContentDto> list = educationContentRepository.findAllToDto(education);
    assert list.size() == educationContentRepository.findAllByEducationUuid(education_uuid).size();
  }

}
package project.toco.service;

import java.util.ArrayList;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import project.toco.dto.EducationContentDto;
import project.toco.dto.EducationDto;
import project.toco.entity.Education;
import project.toco.entity.EducationContent;
import project.toco.repository.EducationRepository;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class EducationService {
  private final EducationRepository educationRepository;

  public Education findById(String uuid){
    return educationRepository.findById(uuid).get();
  }

  public List<Education> findAll(){
    return educationRepository.findAll();
  }

  public String create(EducationDto eduDto, List<EducationContentDto> educationContentDtos){
    Education education = Education.createEducation(eduDto.getName(), eduDto.getIntro(), eduDto.getType(), mapper(educationContentDtos));
    educationRepository.save(education);
    return education.getUuid();
  }

  public void update(EducationDto eduDto, List<EducationContentDto> educationContentDtos){
    Education education = educationRepository.findById(eduDto.getUuid()).get();
    education.setIntro(eduDto.getIntro());
    education.setType(eduDto.getType());

    // 기존 교육서비스 상세가 있는지 확인
    //List<EducationContent> originEducationContents = educationRepository.find

    education.setEducationContents(mapper(educationContentDtos));
  }

  public List<EducationContent> mapper(List<EducationContentDto> educationContentDtos){
    List<EducationContent> educationContents = new ArrayList<>();
    EducationContent educationContent;
    for(EducationContentDto dto : educationContentDtos){
      educationContent = EducationContent.createEducationContents(dto.getChapter(), dto.getName(), dto.getDetails());
      educationContents.add(educationContent);
    }
    return educationContents;
  }
}

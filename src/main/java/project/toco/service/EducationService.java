package project.toco.service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import project.toco.dto.EducationContentDto;
import project.toco.dto.EducationDto;
import project.toco.dto.condition.EduCondition;
import project.toco.entity.Education;
import project.toco.entity.EducationContent;
import project.toco.entity.Level;
import project.toco.repository.EducationRepository;
import project.toco.repository.EducationScoreRepository;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class EducationService {
  private final EducationRepository educationRepository;
  private final EducationScoreRepository educationScoreRepository;

  public EducationDto findOneEduToDto(String uuid){
    EducationDto dto = educationRepository.findOneEduToDto(uuid);
    if(educationScoreRepository.findByEducationUuid(dto.getUuid())!=null)
      dto.setScore(educationScoreRepository.calculateScore(dto.getUuid()));
    return dto;
  }

  public List<EducationDto> findAllToDto() {
    List<EducationDto> educationDtoList = educationRepository.findAllToDto();
    for(EducationDto dto: educationDtoList){
      if(educationScoreRepository.findByEducationUuid(dto.getUuid())!=null)
        dto.setScore(educationScoreRepository.calculateScore(dto.getUuid()));
    }
    return educationDtoList;
  }


  public List<EducationDto> findAllToDtoWithCondition(EduCondition eduCondition) {
    List<EducationDto> educationDtoList = educationRepository.findAllToDtoWithCondition(eduCondition);
    List<EducationDto> scored_educationDtoList = new ArrayList<>();
    for(EducationDto dto: educationDtoList){
      long score = 0;
      if(educationScoreRepository.findByEducationUuid(dto.getUuid())!=null){
        score = educationScoreRepository.calculateScore(dto.getUuid());
      }
      if((int)score==eduCondition.getStar() || eduCondition.getStar()==0){
        dto.setScore(score);
        scored_educationDtoList.add(dto);
      }
    }
    return scored_educationDtoList;
  }

  public Education findById(String uuid){
    return educationRepository.findById(uuid).get();
  }

  public List<Education> findAll(){
    return educationRepository.findAll();
  }

  public List<String> findAllEduNames(){
    return educationRepository.findAllEduNames();
  }

  public String create(EducationDto eduDto, List<EducationContentDto> educationContentDtos){
    Education education = Education.createEducation(eduDto.getName(), eduDto.getIntro(), eduDto.getType(), eduDto.getLevel(), mapper(educationContentDtos));
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
      educationContent = EducationContent.createEducationContents(dto.getChapter(), dto.getName(), dto.getIntro(), dto.getDetails());
      educationContents.add(educationContent);
    }
    return educationContents;
  }

  public List<EducationDto> getTopThree(List<EducationDto> eduList) {
    eduList = eduList.stream().sorted(Comparator.comparing(EducationDto::getScore).reversed())
        .limit(3)
        .collect(Collectors.toList());
    return eduList;
  }
}

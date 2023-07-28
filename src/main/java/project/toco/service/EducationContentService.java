package project.toco.service;

import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import project.toco.dto.EducationContentDto;
import project.toco.dto.EducationDto;
import project.toco.entity.Education;
import project.toco.entity.EducationContent;
import project.toco.repository.EducationContentRepository;
import project.toco.repository.EducationRepository;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class EducationContentService {
  private final EducationRepository educationRepository;
  private final EducationContentRepository educationContentRepository;

  public EducationContent getNextContent(String uuid) {
    EducationContent educationContent = educationContentRepository.findById(uuid).get();
    int nextChapter = educationContent.getChapter()+1;
    Education education = educationContent.getEducation();
    return educationContentRepository.getNextUuid(nextChapter, education);
  }

  public List<EducationContentDto> findAllToDto(String education_uuid) {
    return educationContentRepository.findAllToDto(educationRepository.findById(education_uuid).get());
  }
}

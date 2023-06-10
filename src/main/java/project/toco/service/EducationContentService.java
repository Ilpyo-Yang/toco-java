package project.toco.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import project.toco.entity.Education;
import project.toco.entity.EducationContent;
import project.toco.entity.EducationType;
import project.toco.repository.EducationContentRepository;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class EducationContentService {
  private final EducationContentRepository educationContentRepository;

  public String getNextUuid(String uuid) {
    EducationContent educationContent = educationContentRepository.findById(uuid).get();
    int nextChapter = educationContent.getChapter()+1;
    Education education = educationContent.getEducation();
    return educationContentRepository.getNextUuid(nextChapter, education);
  }

}

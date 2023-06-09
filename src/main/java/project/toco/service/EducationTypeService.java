package project.toco.service;

import java.util.ArrayList;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import project.toco.dto.EducationContentDto;
import project.toco.dto.EducationDto;
import project.toco.dto.EducationTypeDto;
import project.toco.entity.Education;
import project.toco.entity.EducationContent;
import project.toco.entity.EducationType;
import project.toco.repository.EducationRepository;
import project.toco.repository.EducationTypeRepository;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class EducationTypeService {
  private final EducationTypeRepository educationTypeRepository;

  public void create(String main, String sub){
    EducationType type = EducationType.createEducationType(main, sub);
    educationTypeRepository.save(type);
  }

}

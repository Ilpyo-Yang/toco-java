package project.toco.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import project.toco.dto.EducationContentDto;
import project.toco.entity.Education;
import project.toco.entity.EducationContent;
import project.toco.repository.custom.EducationContentCustom;

@Repository
public interface EducationContentRepository extends JpaRepository<EducationContent, String>, EducationContentCustom {
  String getNextUuid(int nextChapter, Education education);
  List<EducationContentDto> findAllToDto(Education education_uuid);
  List<EducationContent> findAllByEducationUuid(String educationUuid);
}

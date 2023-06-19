package project.toco.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import project.toco.dto.EducationDto;
import project.toco.dto.condition.EduCondition;
import project.toco.entity.Education;
import project.toco.repository.custom.EducationCustom;

@Repository
public interface EducationRepository extends JpaRepository<Education, String>, EducationCustom {
  EducationDto findOneEduToDto(String uuid);

  List<EducationDto> findAllToDto(EduCondition eduCondition);
}

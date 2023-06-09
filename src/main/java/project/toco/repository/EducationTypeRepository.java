package project.toco.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import project.toco.dto.EducationTypeDto;
import project.toco.entity.EducationType;
import project.toco.repository.custom.EducationRepositoryCustom;

@Repository
public interface EducationTypeRepository extends JpaRepository<EducationType, String>, EducationRepositoryCustom {
  List<EducationTypeDto> findTypesToDto();
}
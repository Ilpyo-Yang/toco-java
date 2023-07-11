package project.toco.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import project.toco.entity.EducationScore;
import project.toco.repository.custom.EducationScoreCustom;

@Repository
public interface EducationScoreRepository
    extends JpaRepository<EducationScore, String>, EducationScoreCustom {
  long calculateScore(String uuid);
  EducationScore findByEducationUuid(String uuid);
  List<EducationScore> findAllByEducationUuid(String uuid);
}

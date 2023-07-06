package project.toco.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import project.toco.entity.EducationScore;

@Repository
public interface EducationScoreRepository extends JpaRepository<EducationScore, String> {
  long calculateScore(String uuid);
  EducationScore findByEducationUuid(String uuid);
}

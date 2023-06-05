package project.toco.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import project.toco.domain.Education;

@Repository
public interface EducationRepository extends JpaRepository<Education, String> {

}

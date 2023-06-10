package project.toco.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import project.toco.entity.Education;
import project.toco.repository.custom.EducationCustom;

@Repository
public interface EducationRepository extends JpaRepository<Education, String>, EducationCustom {

}

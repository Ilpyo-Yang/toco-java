package project.toco.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import project.toco.entity.EducationType;

@Repository
public interface EducationTypeRepository extends JpaRepository<EducationType, String> {


}

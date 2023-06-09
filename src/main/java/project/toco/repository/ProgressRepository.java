package project.toco.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import project.toco.entity.Progress;

@Repository
public interface ProgressRepository extends JpaRepository<Progress, String> {

}

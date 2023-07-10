package project.toco.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import project.toco.dto.ProgressDto;
import project.toco.entity.Progress;

@Repository
public interface ProgressRepository extends JpaRepository<Progress, String> {
  List<ProgressDto> findByMemberUuid(String memberUuid);
}

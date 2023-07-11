package project.toco.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import project.toco.dto.ProgressDto;
import project.toco.entity.Progress;
import project.toco.repository.custom.ProgressCustom;

@Repository
public interface ProgressRepository extends JpaRepository<Progress, String>, ProgressCustom {
  List<ProgressDto> findByMemberUuidToDto(String memberUuid);
  List<Progress> findByMemberUuid(String memberUuid);
}

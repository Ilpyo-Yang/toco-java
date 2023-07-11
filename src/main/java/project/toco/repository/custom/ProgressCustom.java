package project.toco.repository.custom;

import java.util.List;
import project.toco.dto.ProgressDto;

public interface ProgressCustom {
  List<ProgressDto> findByMemberUuidToDto(String memberUuid);
}

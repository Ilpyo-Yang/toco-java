package project.toco.repository.custom;

import java.util.List;
import project.toco.dto.MemberDto;

public interface MemberRepositoryCustom {

  MemberDto findMemberToDto(String uuid);
  List<MemberDto> findMembersToDto();
}

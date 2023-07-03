package project.toco.repository.custom;

import project.toco.dto.MemberDto;

public interface MemberRepositoryCustom {
  MemberDto findByEmailToDto(String email);
}

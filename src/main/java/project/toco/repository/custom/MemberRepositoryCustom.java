package project.toco.repository.custom;

import java.util.List;
import project.toco.dto.MemberDto;

public interface MemberRepositoryCustom {
  MemberDto findByEmail(String email);
}

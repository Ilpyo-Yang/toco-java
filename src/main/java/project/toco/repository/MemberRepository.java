package project.toco.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import project.toco.dto.EducationTypeDto;
import project.toco.dto.MemberDto;
import project.toco.entity.Member;
import project.toco.repository.custom.MemberRepositoryCustom;

@Repository
public interface MemberRepository extends JpaRepository<Member, String>, MemberRepositoryCustom {
  MemberDto findMemberToDto(String uuid);
  List<MemberDto> findMembersToDto();
}

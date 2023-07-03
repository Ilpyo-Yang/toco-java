package project.toco.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import project.toco.dto.MemberDto;
import project.toco.entity.Member;
import project.toco.repository.custom.MemberRepositoryCustom;

@Repository
public interface MemberRepository extends JpaRepository<Member, String>, MemberRepositoryCustom {
  Member findByEmail(String email);
  MemberDto findByEmailToDto(String email);
}

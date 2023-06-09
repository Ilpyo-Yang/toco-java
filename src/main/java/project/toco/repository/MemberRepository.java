package project.toco.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import project.toco.entity.Member;

@Repository
public interface MemberRepository extends JpaRepository<Member, String> {

}

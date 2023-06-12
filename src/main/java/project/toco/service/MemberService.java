package project.toco.service;

import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import project.toco.dto.form.SignupForm;
import project.toco.entity.Member;
import project.toco.repository.MemberRepository;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class MemberService {
  private final MemberRepository memberRepository;

  public Member findById(String uuid){ return memberRepository.findById(uuid).get(); }

  public List<Member> findAll(){
    return memberRepository.findAll();
  }

  public String create(SignupForm form){
    Member member = Member.createMember(form.getName(), form.getEmail(), form.getPassword(), form.getRole());
    memberRepository.save(member);
    return member.getUuid();
  }

  public String update(Member m){
    Member member = memberRepository.save(m);
    return member.getUuid();
  }

}

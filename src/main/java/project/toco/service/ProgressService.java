package project.toco.service;

import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import project.toco.dto.ProgressDto;
import project.toco.entity.Education;
import project.toco.entity.EducationContent;
import project.toco.entity.Member;
import project.toco.entity.Progress;
import project.toco.entity.Status;
import project.toco.repository.EducationContentRepository;
import project.toco.repository.MemberRepository;
import project.toco.repository.ProgressRepository;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class ProgressService {
  private final ProgressRepository progressRepository;
  private final MemberRepository memberRepository;
  private final EducationContentRepository educationContentRepository;

  public Progress findById(String uuid){
    return progressRepository.findById(uuid).get();
  }

  public List<Progress> findAll(){
    return progressRepository.findAll();
  }

  public String create(Status status, String member_uuid, String education_content_uuid){
    Member member = memberRepository.findById(member_uuid).get();
    EducationContent educationContent = educationContentRepository.findById(education_content_uuid).get();

    Progress progress = Progress.createProgress(status, member, educationContent);
    progressRepository.save(progress);
    return progress.getUuid();  // todo 여기 확인하기
  }
  public void updateContent(String uuid, String education_content_uuid){
    Progress progress = progressRepository.findById(uuid).get();
    progress.setEducation_content(educationContentRepository.findById(education_content_uuid).get());
  }

  public void updateStatus(String uuid, Status status){
    Progress progress = progressRepository.findById(uuid).get();
    progress.setStatus(status);
  }
}

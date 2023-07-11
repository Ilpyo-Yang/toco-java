package project.toco.service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;
import project.toco.dto.ProgressDto;
import project.toco.entity.EducationContent;
import project.toco.entity.Member;
import project.toco.entity.Progress;
import project.toco.entity.Status;
import project.toco.repository.EducationContentRepository;
import project.toco.repository.MemberRepository;
import project.toco.repository.ProgressRepository;

@SpringBootTest
@Transactional
class ProgressServiceTest {
  @Autowired
  ProgressRepository progressRepository;
  @Autowired
  MemberRepository memberRepository;
  @Autowired
  EducationContentRepository educationContentRepository;

  @Test
  void create() {
    Progress progress = Progress.createProgress(LocalDate.now(), "",
        Status.NotStarted,
        memberRepository.findAll().get(0),
        educationContentRepository.findAll().get(0));
    progressRepository.save(progress);
    assert progress.getUuid().equals(progressRepository.findById(progress.getUuid()).get().getUuid());
  }

  @Test
  void updateContent() {
    EducationContent educationContent = educationContentRepository.findAll().get(0);
    Progress progress = progressRepository.findAll().get(0);
    assert !progress.getEducation_content().equals(educationContent);
    progress.setEducation_content(educationContent);
    assert progressRepository.findAll().get(0).getEducation_content().equals(educationContent);
  }

  @Test
  void updateStatus() {
    // if문에 걸릴 Progress 가지고 오는 경우
    Progress progress = progressRepository.findAll().get(0);
    if(!Status.Finished.equals(progress.getStatus())) progress.setStatus(Status.Finished);
    assert Status.Finished.equals(progress.getStatus());
  }

  @Test
  void findByMemberUuidToDto() {
    String memberUuid = memberRepository.findAll().get(0).getUuid();
    List<ProgressDto> progressDtoList = progressRepository.findByMemberUuidToDto(memberUuid);
    List<ProgressDto> checkedList = progressDtoList.stream()
                                      .filter(f -> !f.getMemberUuid().equals(memberUuid))
                                      .collect(Collectors.toList());
    assert checkedList.size()==0;
  }

  // getNotStartCnt(), getProgressCnt(), getFinishedCnt(), getStoppedCnt() 유사로직
  @Test
  void getStatusCnt() {
    Status status = Status.InProgress;
    Member member = memberRepository.findAll().get(0);
    List<ProgressDto> progressDtoList = progressRepository.findByMemberUuidToDto(member.getUuid());
    int streamCnt = progressDtoList.stream()
                          .filter(dto -> dto.getStatus().equals(status))
                          .collect(Collectors.toList())
                          .size();
    int count=0;
    for(ProgressDto dto: progressDtoList){
      if(status.equals(dto.getStatus())) count++;
    }
    assert streamCnt == count;
  }



  // spring data
  @Test
  void findById() {
  }

  // spring data
  @Test
  void findAll() {
  }
}
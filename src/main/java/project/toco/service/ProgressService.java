package project.toco.service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import project.toco.dto.ProgressDto;
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

  @Transactional
  public String create(LocalDate startDate, String mailingDays, String member_uuid, String education_uuid){
    Member member = memberRepository.findById(member_uuid).get();
    List<EducationContent> educationContents = educationContentRepository.findAllByEducationUuid(education_uuid);
    Progress progress = Progress.createProgress(startDate, mailingDays, Status.NotStarted, member, educationContents.get(0));
    progressRepository.save(progress);
    return progress.getUuid();
  }

  @Transactional
  public void updateContent(String uuid, String education_content_uuid){
    Progress progress = progressRepository.findById(uuid).get();
    progress.setEducation_content(educationContentRepository.findById(education_content_uuid).get());
  }

  @Transactional
  public void updateStatus(String uuid, Status status){
    Progress progress = progressRepository.findById(uuid).get();
    progress.setStatus(status);
  }

  public List<ProgressDto> findByMemberUuidToDto(String memberUuid) {
    return progressRepository.findByMemberUuidToDto(memberUuid);
  }

  public int getNotStartCnt(List<ProgressDto> progressDtoList) {
    if(progressDtoList==null) return 0;
    return progressDtoList
        .stream()
        .filter(dto -> dto.getStatus().equals(Status.NotStarted))
        .collect(Collectors.toList())
        .size();
  }

  public int getProgressCnt(List<ProgressDto> progressDtoList) {
    if(progressDtoList==null) return 0;
    return progressDtoList
        .stream()
        .filter(dto -> dto.getStatus().equals(Status.InProgress))
        .collect(Collectors.toList())
        .size();
  }

  public int getFinishedCnt(List<ProgressDto> progressDtoList) {
    if(progressDtoList==null) return 0;
    return progressDtoList
        .stream()
        .filter(dto -> dto.getStatus().equals(Status.Finished))
        .collect(Collectors.toList())
        .size();
  }

  public int getStoppedCnt(List<ProgressDto> progressDtoList) {
    if(progressDtoList==null) return 0;
    return progressDtoList
        .stream()
        .filter(dto -> dto.getStatus().equals(Status.Stopped))
        .collect(Collectors.toList())
        .size();
  }

  public Progress findById(String uuid){
    return progressRepository.findById(uuid).get();
  }
  public List<Progress> findAll(){
    return progressRepository.findAll();
  }
}

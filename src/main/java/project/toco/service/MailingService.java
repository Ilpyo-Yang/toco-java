package project.toco.service;

import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import project.toco.component.Mail;
import project.toco.dto.MailDto;
import project.toco.entity.EducationContent;
import project.toco.entity.MailingLog;
import project.toco.entity.Progress;
import project.toco.entity.Status;
import project.toco.repository.EducationContentRepository;
import project.toco.repository.MailingLogRepository;
import project.toco.repository.ProgressRepository;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class MailingService {
  private final ProgressRepository progressRepository;
  private final EducationContentRepository educationContentRepository;
  private final MailingLogRepository mailingLogRepository;
  private final Mail mail;

  public void mailing() throws Exception {
    List<MailDto> list = progressRepository.findMailingTargetToDto();
    for(MailDto dto: list){
      mail.send(dto);

      /*
        수강과 관련된 경우의 수
        1. 수강전은 첫 메일링 후, 수강중으로 변경
        2. 수강중이지만 마지막 메일링인 경우, 수강완료로 변경
        3. 수강정지 상태였지만 메일링 가능한 경우, 수강중 또는 수강완료로 변경
      */

      Progress progress = progressRepository.findById(dto.progressUuid).get();
      EducationContent educationContent = educationContentRepository.getNextUuid(dto.educationContentChapter+1, progress.getEducation_content().getEducation());

      if(educationContent==null){
        progress.setStatus(Status.Finished);
      }else if(progress.getStatus().equals(Status.NotStarted)){
        progress.setStatus(Status.InProgress);
      }
      progress.setEducation_content(educationContent);

      // 로그
      mailingLogRepository.save(MailingLog.createMailingLog(dto.toEmail, dto.progressUuid));
    }
  }
}

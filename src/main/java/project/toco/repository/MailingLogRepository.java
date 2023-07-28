package project.toco.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import project.toco.entity.EducationType;
import project.toco.entity.MailingLog;

@Repository
public interface MailingLogRepository extends JpaRepository<MailingLog, String> {
}

package project.toco.component;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import project.toco.service.MailingService;

@Component
@Slf4j
public class Batch {
    @Autowired
    MailingService mailingService;

    @Scheduled(cron = "0 0 9 * * ?")
    public void mailingSchedule() throws Exception {
        mailingService.mailing();
        log.info("메일링 내역:" + DateTimeFormatter.ofPattern("yyyyMMddhhmmss").format(LocalDateTime.now()));
    }
}
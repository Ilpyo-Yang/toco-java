package project.toco.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
@Transactional
public class MailingServiceTest {
  @Autowired
  MailingService mailingService;

  @Test
  @Rollback(false)
  public void mailing() throws Exception {
    mailingService.mailing();
  }
}
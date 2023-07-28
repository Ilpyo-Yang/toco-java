package project.toco.component;

import jakarta.mail.Message;
import jakarta.mail.PasswordAuthentication;
import jakarta.mail.Session;
import jakarta.mail.Transport;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeMessage;
import java.io.InputStreamReader;
import java.io.Reader;
import java.text.MessageFormat;
import java.util.Properties;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;
import org.springframework.util.FileCopyUtils;
import project.toco.dto.MailDto;

@Component
public class Mail {
    @Value("${spring.mail.username}")
    private String username;
    @Value("${spring.mail.password}")
    private String password;

    public void send(MailDto dto) throws Exception {
        Properties props = System.getProperties();
        props.put("mail.smtp.port", 25);
        props.put("mail.smtp.host" , "smtp.gmail.com");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.socketFactory.fallback", "true");
        props.put("mail.smtp.auth", "true");

        Session session = Session.getDefaultInstance(props, new jakarta.mail.Authenticator(){
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username, password);
            }
        });

        MimeMessage message = new MimeMessage(session);
        Transport transport = session.getTransport();

        try {
            message.setFrom(new InternetAddress(dto.fromEmail, dto.fromName, "utf-8"));
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(dto.toEmail));
            message.setSubject(dto.educationName+" "+(dto.educationContentChapter+1)+"강. "+dto.educationContentDetails, "utf-8");

            Reader reader = new InputStreamReader(new ClassPathResource("/templates/mailTemplate.html").getInputStream(), "utf-8");
            String template = FileCopyUtils.copyToString(reader);
            String mail = MessageFormat.format(template, dto.toName,
                dto.educationName,
                dto.educationContentChapter+1,
                dto.educationContentName,
                dto.educationContentIntro,
                dto.educationContentDetails);

            message.setContent(mail, "text/html; charset=utf-8");
            transport.send(message);
        } catch (Exception e) {
            //result = String.format(e.getMessage());
            e.printStackTrace();
            transport.close();
        } finally {
            transport.close();
            //log.info("{}={}", result, mails.toString());
        }
    }
}
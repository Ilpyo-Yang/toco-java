package project.toco.dto;

import lombok.ToString;
import org.springframework.beans.factory.annotation.Value;

@ToString(exclude = {"body", "directions"})
public class MailDto {
  public String progressUuid;

  public String fromEmail = "todaycoding1015@gmail.com";
  public String fromName = "toco";

  public String toEmail;
  public String toName;

  public String educationContentUuid;
  public String educationContentName;
  public int educationContentChapter;
  public String educationContentIntro;
  public String educationContentDetails;

  public String educationUuid;
  public String educationName;
}

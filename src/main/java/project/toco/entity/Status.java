package project.toco.entity;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public enum Status {
  NotStarted("수강 전"), InProgress("수강 중"), Finished("완료"), Canceled("수강취소");

  private final String name;
  Status(String name) {
    this.name = name;
  }
}

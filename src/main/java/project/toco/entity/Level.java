package project.toco.entity;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public enum Level {
  Basic("기초"), Challenge("심화"), Expert("전문가");

  private final String name;
  Level(String name) {
    this.name = name;
  }
}

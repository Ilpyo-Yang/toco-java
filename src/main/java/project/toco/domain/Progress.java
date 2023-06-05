package project.toco.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Progress {
  @Id
  @GeneratedValue(strategy = GenerationType.UUID)
  String uuid;
  String name;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name="member_uuid")
  Member member;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name="education_uuid")
  Education education;
}

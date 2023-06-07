package project.toco.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Member extends BaseTimeEntity {
  @Id
  @GeneratedValue(strategy = GenerationType.UUID)
  @Column(name="member_uuid")
  private String uuid;
  private String name;
  @Column(unique = true)
  private String email;
  private String password;
  private String role;

  @JsonIgnore
  @OneToMany(mappedBy = "member", cascade = CascadeType.ALL)
  private List<Progress> progresses = new ArrayList<>();

  public void addProgress(Progress progress) {
    progresses.add(progress);
    progress.setMember(this);
  }
  public static Member createMember(String name, String email, String password, String role, Progress... progresses){
    Member member = new Member();
    member.setName(name);
    member.setEmail(email);
    member.setPassword(password);
    member.setRole(role);
    for(Progress progress : progresses){
      member.addProgress(progress);
    }
    return member;
  }
}

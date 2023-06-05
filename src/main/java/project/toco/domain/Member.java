package project.toco.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
public class Member {
  @Id
  @GeneratedValue(strategy = GenerationType.UUID)
  String uuid;
  String name;
  @Column(unique = true)
  String email;
  String password;
  String role;

  @JsonIgnore
  @OneToMany(mappedBy = "member")
  List<Progress> list = new ArrayList<>();
  public static Member createMember(String name, String email, String password, String role){
    Member member = new Member();
    member.setName(name);
    member.setEmail(email);
    member.setPassword(password);
    member.setRole(role);
    return member;
  }
}

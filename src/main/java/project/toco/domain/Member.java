package project.toco.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Entity;

import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Member {
  @Id
  String uuid;
  String name;
  String email;
  String password;
  String role;

  @JsonIgnore
  @OneToMany(mappedBy = "member")
  List<Progress> list = new ArrayList<>();
}

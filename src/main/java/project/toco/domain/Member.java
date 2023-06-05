package project.toco.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor
public class Member {
  @Id
  @GeneratedValue(strategy = GenerationType.UUID)
  String uuid;
  String name;
  String email;
  String password;
  String role;

  @JsonIgnore
  @OneToMany(mappedBy = "member")
  List<Progress> list = new ArrayList<>();
}

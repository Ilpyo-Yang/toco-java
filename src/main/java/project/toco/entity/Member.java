package project.toco.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Convert;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import project.toco.security.ColumnEncryptor;

@Entity
@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Member extends BaseTimeEntity implements UserDetails {
  @Id
  @GeneratedValue(strategy = GenerationType.UUID)
  @Column(name="member_uuid")
  private String uuid;
  @Convert(converter = ColumnEncryptor.class)
  private String name;
  @Column(unique = true)
  @Convert(converter = ColumnEncryptor.class)
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

  @Override
  public Collection<? extends GrantedAuthority> getAuthorities() {
    return List.of(new SimpleGrantedAuthority(role));
  }

  @Override
  public String getUsername() {
    return email;
  }

  @Override
  public String getPassword() {
    return password;
  }

  @Override
  public boolean isAccountNonExpired() {
    return true;
  }

  @Override
  public boolean isAccountNonLocked() {
    return true;
  }

  @Override
  public boolean isCredentialsNonExpired() {
    return true;
  }

  @Override
  public boolean isEnabled() {
    return true;
  }
}

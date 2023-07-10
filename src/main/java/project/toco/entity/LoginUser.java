package project.toco.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
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

@Entity
@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class LoginUser implements UserDetails {
  @Id
  private String uuid;
  private String name;
  private String email;
  private String password;
  private String role;

  public static LoginUser create(String uuid, String name, String email, String password, String role){
    LoginUser user = new LoginUser();
    user.setUuid(uuid);
    user.setName(name);
    user.setEmail(email);
    user.setPassword(password);
    user.setRole(role);
    return user;
  }

  @Override
  public Collection<? extends GrantedAuthority> getAuthorities() {
    Collection<SimpleGrantedAuthority> grantedAuthorities = new ArrayList<>();
    grantedAuthorities.add(new SimpleGrantedAuthority(role));
    return grantedAuthorities;
  }

  @Override
  public String getUsername() {
    return email;
  }

  public String getName() {
    return name;
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

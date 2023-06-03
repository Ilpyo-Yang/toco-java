package project.toco.config;

import static org.springframework.security.config.Customizer.withDefaults;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import project.toco.security.TokenFilter;
import project.toco.security.TokenProvider;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity
@RequiredArgsConstructor
public class SecurityConfig {
  private final TokenProvider tokenProvider;

  @Bean
  public PasswordEncoder passwordEncoder() {
    return PasswordEncoderFactories.createDelegatingPasswordEncoder();
  }

  @Bean
  public UserDetailsService userDetailsService(PasswordEncoder passwordEncoder) {
    InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager();
    manager.createUser(User.withUsername("user")
        .password(passwordEncoder.encode("userPass"))
        .roles("USER")
        .build());
    manager.createUser(User.withUsername("admin")
        .password(passwordEncoder.encode("adminPass"))
        .roles("USER", "ADMIN")
        .build());
    return manager;
  }

  @Bean
  public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
    return http
              .authorizeHttpRequests(authorize -> authorize
                  .requestMatchers("/", "/login", "/logout", "/css/**", "/js/**", "/font/**").permitAll()
                  .requestMatchers("/user/**").hasRole("USER")
                  .requestMatchers("/admin/**").hasRole("ADMIN")
                  .anyRequest().authenticated()
              )
              .addFilterBefore(new TokenFilter(tokenProvider), UsernamePasswordAuthenticationFilter.class)
              .formLogin(formLogin -> formLogin
                  .loginPage("/login")
                  .permitAll()
              )
              .logout(logout -> logout
                  .logoutUrl("/logout")
                  .permitAll()
              )
              .build();
  }

}
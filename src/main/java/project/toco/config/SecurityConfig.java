package project.toco.config;

import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import project.toco.security.TokenFilter;
import project.toco.service.AuthService;

@Configuration
@AllArgsConstructor
@EnableWebSecurity
@EnableGlobalMethodSecurity(securedEnabled = true)
public class SecurityConfig {
  private final TokenFilter tokenFilter;
  private final AuthService authService;

  @Bean
  public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
    return http
        .csrf().disable()
//        .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
//        .and()
        .authorizeHttpRequests()
          .requestMatchers("/mypage/**").authenticated()
          .requestMatchers("/admin/**").hasAuthority("ROLE_ADMIN")
          .anyRequest().permitAll()
        .and()
        .addFilterBefore(tokenFilter, UsernamePasswordAuthenticationFilter.class)
        .userDetailsService(authService)
        .formLogin()
          .loginPage("/login")
          .loginProcessingUrl("/login")
          .usernameParameter("email")
          .passwordParameter("password")
          .defaultSuccessUrl("/")
//          .successHandler((request, response, authentication) ->
//              response.sendRedirect(request.getHeader("Referer")))
          .failureUrl("/login?error=true")
        .and()
        .logout()
          .logoutSuccessHandler((request, response, authentication) ->
              response.sendRedirect(request.getHeader("Referer")))
        .and()
        .build();
  }

  @Bean
  public BCryptPasswordEncoder passwordEncoder() {
    return new BCryptPasswordEncoder(16);
  }

//  @Bean
//  public DaoAuthenticationProvider daoAuthenticationProvider(){
//    DaoAuthenticationProvider daoAuthenticationProvider = new DaoAuthenticationProvider();
//    daoAuthenticationProvider.setPasswordEncoder(passwordEncoder());
//    daoAuthenticationProvider.setUserDetailsService(authService);
//    return daoAuthenticationProvider;
//  }
}
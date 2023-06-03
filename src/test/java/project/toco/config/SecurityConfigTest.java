package project.toco.config;

import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.user;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest
class SecurityConfigTest {
  //@Autowired
  //MockMvc mockMvc;

  /*@Test
  @WithMockUser
  void securityTest() {
    mockMvc.perform(get("/")
          .with(user("jake").roles("USER")))
          .andDo(print())
          .andExpect(status().isOk());
  }*/
}
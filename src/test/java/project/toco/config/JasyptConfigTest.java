package project.toco.config;

import org.jasypt.encryption.StringEncryptor;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@SpringBootTest
public class JasyptConfigTest {
  final StringEncryptor stringEncryptor = new AnnotationConfigApplicationContext(JasyptConfig.class).getBean("jasyptEncryptor", StringEncryptor.class);

  @Test
  public void stringEncryptorTest(){
    String test = "stringEncryptorTest";
    String encrypt_test = stringEncryptor.encrypt(test);
    //System.out.println(stringEncryptor.encrypt(""));
    assert test.equals(stringEncryptor.decrypt(encrypt_test));
  }
}
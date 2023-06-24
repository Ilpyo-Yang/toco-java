package project.toco.security;

import jakarta.annotation.PostConstruct;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;
import java.nio.charset.StandardCharsets;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import org.springframework.beans.factory.annotation.Value;

@Converter
public class ColumnEncryptor implements AttributeConverter<String, String> {

  @Value("${spring.database.column.encrypt.key}")
  private String key;

  private Cipher encryptCipher;
  private Cipher decryptCipher;

  @PostConstruct
  public void init() throws Exception{
    encryptCipher = Cipher.getInstance("AES");
    encryptCipher.init(Cipher.ENCRYPT_MODE, generateKey(key));
    decryptCipher = Cipher.getInstance("AES");
    decryptCipher.init(Cipher.DECRYPT_MODE, generateKey(key));
  }

  @Override
  public String convertToDatabaseColumn(String attribute) {
    try {
      return new String(encryptCipher.doFinal(attribute.getBytes(StandardCharsets.UTF_8)));
    } catch (Exception e) {
      e.printStackTrace();
    }
    return null;
  }

  @Override
  public String convertToEntityAttribute(String dbData) {
    try {
      return new String(decryptCipher.doFinal(dbData.getBytes()));
    }catch (Exception e) {
      e.printStackTrace();
    }
    return null;
  }

  public static SecretKeySpec generateKey(String key) {
    try {
      return new SecretKeySpec(key.getBytes(StandardCharsets.UTF_8), "AES");
    } catch(Exception e) {
      e.printStackTrace();
    }
    return null;
  }
}
package project.toco.security;

import com.fasterxml.jackson.databind.ser.Serializers.Base;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;
import java.nio.charset.StandardCharsets;
import java.util.Base64;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;

@Converter
@RequiredArgsConstructor
public class ColumnEncryptor implements AttributeConverter<String, String> {

  @Value("${spring.datasource.column.encrypt.key}")
  private String key;

  private Cipher encryptCipher;
  private Cipher decryptCipher;

  /*@PostConstruct
  public void init() throws Exception{
    encryptCipher = Cipher.getInstance("AES");
    encryptCipher.init(Cipher.ENCRYPT_MODE, generateKey(key));
    decryptCipher = Cipher.getInstance("AES");
    decryptCipher.init(Cipher.DECRYPT_MODE, generateKey(key));
  }*/

  @Override
  public String convertToDatabaseColumn(String attribute) {
    try {
      encryptCipher = Cipher.getInstance("AES");
      encryptCipher.init(Cipher.ENCRYPT_MODE, generateKey(key, "UTF-8"));
      return new String(Base64.getEncoder().encodeToString(encryptCipher.doFinal(attribute.getBytes())));
    } catch (Exception e) {
      e.printStackTrace();
    }
    return null;
  }

  @Override
  public String convertToEntityAttribute(String dbData) {
    try {
      decryptCipher = Cipher.getInstance("AES");
      decryptCipher.init(Cipher.DECRYPT_MODE, generateKey(key, "UTF-8"));
      return new String(decryptCipher.doFinal(Base64.getDecoder().decode(dbData.getBytes())), StandardCharsets.UTF_8);
    }catch (Exception e) {
      e.printStackTrace();
    }
    return null;
  }

  public static SecretKeySpec generateKey(String key, String encoding) {
    try {
      return new SecretKeySpec(key.getBytes(encoding), "AES");
    } catch(Exception e) {
      e.printStackTrace();
    }
    return null;

    /*try {
      final byte[] finalKey = new byte[16];
      int i = 0;
      for(byte b : key.getBytes(encoding))
        finalKey[i++%16] ^= b;
      return new SecretKeySpec(finalKey, "AES");
    } catch(UnsupportedEncodingException e) {
      throw new RuntimeException(e);
    }*/
  }
}
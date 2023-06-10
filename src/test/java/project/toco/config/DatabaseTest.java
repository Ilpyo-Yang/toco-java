package project.toco.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class DatabaseTest {
  @Test
  public void connectionTest(){
    try{
      Connection conn = DriverManager.getConnection(
          "jdbc:mysql://localhost:3306/today_coding","root","1234abcd!"
      );
      assert conn != null;
      conn.close();
    }catch (SQLException e){
      e.printStackTrace();
    }
  }
}

package project.toco.util;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import org.springframework.stereotype.Component;

@Component
public class Utils {
  public static String getRandomFileName(String directory){
    List<String> list = new ArrayList<>();
    File file = new File(directory);
    if(file!=null){
      File[] files = file.listFiles();
      for(File f:files){
        list.add(f.getName());
      }
    }
    return list.get(new Random().nextInt(list.size()));
  }
}

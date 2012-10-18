/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package joectp;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author Administrator
 */
public class FileReader {
    final static Charset ENCODING = StandardCharsets.UTF_8;
    Boolean inFixes = false;
    
    public String[][] readLargerTextFileAlternate(String aFileName) throws IOException {
    Path path = Paths.get(aFileName);
    String[][] fixes = new String[10000000][3];
    try (BufferedReader reader = Files.newBufferedReader(path, ENCODING)){
      String line = null;
      int i = 0;
      while ((line = reader.readLine()) != null) {
        //process each line in some way
        if(line.contains("[FIX"))
        {
            inFixes = true;
            continue;
        }
        
        if(inFixes)
        {
            if(line.contains("["))
            {
                inFixes = false;
                continue;
            }
            if (line.startsWith(";"))
            {
                continue;
            }
            
            String[] fixLine = line.split("\\s+");
            int j = 0;
            for(String fix : fixLine)
            {
                fixes[i][j] = fix;
                j++;
            }
            i++;
        }
      }
      
//      for(String[] fix : fixes)
//      {
//          System.out.println(fix[0]);
//          System.out.println(fix[1]);
//          System.out.println(fix[2]); 
//      }
    }
    
    return fixes;
  }
}

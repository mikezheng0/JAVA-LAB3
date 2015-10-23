/**
 * COMP10152 - Lab#3 Starter Code 
 * @author C. Mark Yendt
 * @version 1.0 (May 2014)
 */

package comp10152_lab3;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Comp10152_Lab3_Start {

  /**
   * The starting point of the application 
   * @param args the command line arguments - not used
   */
  public static void main(String[] args) 
  {
    // File is stored in a resources folder in the project
    final String filename = "resources/tale.txt";
 
    try {
      Scanner fin = new Scanner(new File(filename));
      fin.useDelimiter("\\s|\"|\\(|\\)|\\.|\\,|\\?|\\!|\\_|\\-|\\:|\\;|\\n");  // Filter - DO NOT CHANGE 
      while (fin.hasNext()) {
        String fileWord = fin.next().toLowerCase();
        if (fileWord.length() > 0)
        {
            System.out.printf("%s\n", fileWord);
        
        
            // Need to create an instance of a Word object here and add to ArrayList
        
        }
      }
      fin.close();
    } catch (FileNotFoundException e) {
      System.out.println("Exception caught: " + e.getMessage());
    }

    // Analyze and report code here based on lab requirements
    
  }
}


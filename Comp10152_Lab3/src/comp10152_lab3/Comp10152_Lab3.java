/**
 * COMP10152 - Lab#3 Starter Code 
 * @author C. Mark Yendt
 * @version 1.0 (May 2014)
 */

package comp10152_lab3;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Comp10152_Lab3 {

  /**
   * The starting point of the application 
   * @param args the command line arguments - not used
   */
  public static void main(String[] args) 
  {
    // File is stored in a resources folder in the project
    final String filename = "resources/tale.txt";
    int countOfWords = 0;
    int countTotalWords = 0;
    ArrayList<Word> list = new ArrayList<Word>();
    try {
      Scanner fin = new Scanner(new File(filename));
      fin.useDelimiter("\\s|\"|\\(|\\)|\\.|\\,|\\?|\\!|\\_|\\-|\\:|\\;|\\n");  // Filter - DO NOT CHANGE 
      while (fin.hasNext()) {
        String fileWord = fin.next().toLowerCase();
        if (fileWord.length() > 0)
        {
            countTotalWords++;
            Word temp = new Word(fileWord);
            int index = list.indexOf(temp);
            //if it doesn't exist, add to arrayList
            if(index == -1)
            {
                list.add(temp);
            }
            //it does exist, increment count
            else
            {
                list.get(index).incrementCount();
            }
            // Need to create an instance of a Word object here and add to ArrayList
        }
      }
      fin.close();
    } catch (FileNotFoundException e) {
      System.out.println("Exception caught: " + e.getMessage());
    }
    System.out.println("There are a total of "+list.size()+" different words in the file.");
    System.out.println("There are a total of "+countTotalWords+" words in the file.");
    System.out.println("The list of the 10 most frequent words and counts : ");
    Collections.sort(list); 
    for (int i = 0; i < 10; i++)
    {
        System.out.printf("%2d : %s\n",i+1,list.get(i).toString());
    }
    System.out.println("The words below each occur 13 times in the file:");
    for (int i = 0; i < list.size(); i++)
    {
        int tempCount = 0;
        if (list.get(i).getCount()==13)
            System.out.print(list.get(i).toString());
        for (int j = 0; j < list.get(i).getWord().length(); j++)
        {
            if ((list.get(i).getWord().charAt(j))=='s')
                tempCount++;
        }
        if (tempCount>=2)
        {
            countOfWords++;
        }
    }
    System.out.printf("\nThere are %d different words that contain more than one 's'.", countOfWords);
  }
}


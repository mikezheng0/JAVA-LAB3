package comp10152_lab3;
/** This class is used for word objects with the comparable interface 
 * @author Mike Zheng
 * I Mike Zheng, 000348657 certify that this material is my original work. No other person's work has been 
 * used without due acknowledgment. I have not made my work available to anyone else.
 */
public class Word implements Comparable<Word>
{
    private String inWord;
    private int count;
    
    /** initialize the class with count of 1 and input word
     * 
     * @param word - word to be stored in the class
     */
    public Word(String word)
    {
        inWord = word;
        count = 1;
    }
    
    /** gets the word
     * 
     * @return the word from the class
     */
    public String getWord()
    {
        return inWord;
    }
    
    /** Gets the count
     * 
     * @return the count 
     */
    public int getCount()
    {
        return count;
    }
    
    /** Increment the count
     * 
     */
    public void incrementCount()
    {
        count++;
    }
    
    /** returns a formated string
     * @return the string version of the class that includes the count and word
     */
    @Override
    public String toString()
    {
        return String.format("[%6s, %3d]", inWord , count);
    }
    
    /** This class check the object type of the input object and try to get a 
     * string from it using a cast then it will check if they are the same
     * 
     * @param wordToCompare input object 
     * @return boolean indicating their lexicographical equality 
     */
    @Override
    public boolean equals(Object wordToCompare)
    {
        String stringOfWord = null;
        if(wordToCompare instanceof Word)
        {
            stringOfWord = ((Word)wordToCompare).getWord();
        }
        else if(wordToCompare instanceof String)
        {
            stringOfWord = (String)wordToCompare;
        }
        
        return stringOfWord != null && this.inWord.equals(stringOfWord);
    }
    
    /** Will determine greater values based on count first and then string based comparison
     * 
     * @param wordtoCompare the word to be compared
     * @return returns negative, positive or 0 integer indicating its order
     */
    @Override
    public int compareTo(Word wordtoCompare)
    {
        int diff =  wordtoCompare.getCount()- this.count;

        if(diff == 0)
        {
            return this.inWord.compareTo(wordtoCompare.getWord());
        }

        return diff;
    }
    
    

}

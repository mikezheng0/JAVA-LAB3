package comp10152_lab3;
public class Word implements Comparable<Word>
{
    private String wordCharacters;
    private int count;
    
    public Word(String word)
    {
        wordCharacters = word;
        count = 1;
    }
    
    public String getWord()
    {
        return wordCharacters;
    }
    
    public int getCount()
    {
        return count;
    }
    
    public void incrementCount()
    {
        count++;
    }
    
    @Override
    public String toString()
    {
        return String.format("[%6s, %3d]", wordCharacters , count);
    }
    
    @Override
    public boolean equals(Object wordToCompare)
    {
        String other = null;
        if(wordToCompare instanceof Word)
        {
            other = ((Word)wordToCompare).getWord();
        }
        else if(wordToCompare instanceof String)
        {
            other = (String)wordToCompare;
        }
        
        return other != null && this.wordCharacters.equals(other);
    }

    @Override
    public int compareTo(Word wordtoCompare )
    {
        int diff =  wordtoCompare.getCount()- this.count;

        if(diff == 0)
        {
            return this.wordCharacters.compareTo(wordtoCompare.getWord());
        }

        return diff;
    }
    
    

}

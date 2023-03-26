import java.util.*;
public class WordGram {
    private String[] myWords;
    private int myHash;

    public WordGram(String[] source, int start, int size) { myWords = new String[size];
        System.arraycopy(source, start, myWords, 0, size);
    }

    public int hashCode()
    {
	
	    return this.toString().hashCode();
    }
    public String wordAt(int index) {
        if (index < 0 || index >= myWords.length) {
            throw new IndexOutOfBoundsException("bad index in wordAt "+index);
        }
        return myWords[index];
    }

    public int length(){
        // TODO: Complete this method
        return myWords.length;
    }

	public String toString() {
	    StringBuilder sb = new StringBuilder();
	    for (int i = 0; i < myWords.length; i++) {
		sb.append(myWords[i]);
		if (i != myWords.length - 1) {
		    sb.append(" ");
		}
	    }
	    return sb.toString().trim();
	}

    public boolean equals(Object o) {
        WordGram other = (WordGram) o;
        // TODO: Complete this method
	for (int i = 0; i < myWords.length; i++)
	{
		if (!myWords[i].equals(other.wordAt(i)))
			return false;
	}
        return true;

    }

    public WordGram shiftAdd(String word) {	
        WordGram out = new WordGram(myWords, 0, myWords.length);
	String sr = "";
	String line = out.toString();
        // shift all words one towards 0 and add word at the end. 
	int index = line.indexOf(" ");
        // you lose the first word
	line = line.substring(index+1);
	line = line + " " + word;
	String[] newWords = line.split("\\s+");	
	out = new WordGram(newWords, 0, newWords.length);
        // TODO: Complete this method
        return out;
    }

}

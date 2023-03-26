
/**
 * Write a description of class MarkovWord here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

import java.util.*;

public class MarkovWord implements IMarkovModel {
    private String[] myText;
    private Random myRandom;
    private int myOrder;    
    public MarkovWord(int order) {
        myRandom = new Random();
	myOrder = order;
    }
    
    public void setRandom(int seed) {
        myRandom = new Random(seed);
    }
    
    public void setTraining(String text){
		myText = text.split("\\s+");
	}
	private String substring(String[] words, int start, int end)	
	{
		String sr = "";
		for (int i = start; i < end; i++)
		{
			sr += words[i];
			sr  = sr + " ";
		}
		return sr.trim();
	}
    public int indexOf(String[] words, WordGram target, int start)
    {
	    for (int i = start; i < words.length - target.length(); i++)
	    {
		    String s = substring(words, i, i+target.length());
		    if (target.toString().equals(s))
			    return i;
	    }
	    return -1;
    }

	private String[] substring(int start, int end, int size)
	{
	    String[] source = new String[size];
	    for (int i = start, k = 0; i <= end && k < size; i++, k++)
	    {
		source[k] = myText[i];
	    }
	    return source;
	}

	public String getRandomText(int numWords){
	    StringBuilder sb = new StringBuilder();
	    int index = myRandom.nextInt(myText.length - myOrder);
	    WordGram currentGram = new WordGram(myText, index, myOrder);
	    sb.append(currentGram.toString()).append(" ");

	    for(int k=0; k < numWords  - myOrder; k++){
		ArrayList<String> follows = getFollows(currentGram);
		if (follows.size() == 0) {
		    break;
		}
		index = myRandom.nextInt(follows.size());
		String nextWord = follows.get(index);
		sb.append(nextWord).append(" ");
		currentGram = currentGram.shiftAdd(nextWord);
	    }

	    return sb.toString().trim();
	}
		
	
	public ArrayList<String> getFollows(WordGram kGram)
	{
		ArrayList<String> follows = new ArrayList<String>();
		// Finding Follow Sets
		int loc = indexOf(myText, kGram, 0); 
		//As long as there is key and key isnt last char:
		if (myText == null)
		{
			System.out.println("TraininTextIsNotSet");
		}
		while(loc != -1)
		{
			if (loc == myText.length - kGram.length())
				break;
			//get the location of the key Then add on it
			//the key Length get the char after it 
			int pos = loc + kGram.length();
			String follow = myText[pos];
			//Then put it in storage space call it follows
			follows.add(follow);	
			loc = indexOf(myText, kGram, pos+1);
		}
		//return follows and thats answer
		return follows;
	}
}


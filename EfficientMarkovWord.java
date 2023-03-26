
/**
 * Write a description of class EfficientMarkovWord here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

import java.util.*;

public class EfficientMarkovWord implements IMarkovModel {
    private String[] myText;
    private Random myRandom;
    private int myOrder;    
    private HashMap<WordGram, ArrayList<String>> myMap;
    public EfficientMarkovWord(int order) {
        myRandom = new Random();
	myOrder = order;
	myMap = new HashMap<WordGram, ArrayList<String>>();
    }
    
    public void setRandom(int seed) {
        myRandom = new Random(seed);
    }
    
    public void setTraining(String text){
		myMap.clear();
		myText = text.split("\\s+");
		buildMap();
		printHashMapInfo();
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
	if (myText.length <= myOrder) {
	    throw new IllegalArgumentException("Text length must be greater than order");
	}
	    int index = myRandom.nextInt(myText.length - myOrder);
	    WordGram currentGram = new WordGram(myText, index, myOrder);
	    sb.append(currentGram.toString()).append(" ");

	    for(int k=0; k < numWords  - myOrder; k++){
		ArrayList<String> follows = getFollows(currentGram);
		if (follows == null) {
		    break;
		}
		index = myRandom.nextInt(follows.size());
		String nextWord = follows.get(index);
		sb.append(nextWord).append(" ");
		currentGram = currentGram.shiftAdd(nextWord);
	    }

	    return sb.toString().trim();
	}
	public void buildMap()
	{
		// Finding Follow Sets
		for (int i = 0; i < myText.length - myOrder; i++)
		{
			//String[] source = substring(i, i+myOrder, myOrder);
			WordGram target = new WordGram(myText, i, myOrder);
			if (!myMap.containsKey(target))
			{
				myMap.put(target, new ArrayList<String>());
//				int loc = indexOf(myText, target, i);
//				ArrayList<String> follows = new ArrayList<String>();
//				while (loc != -1)
//				{
//					// this is a test (a) cool test this is
//					int pos = loc + myOrder;	
//					follows.add(myText[pos+1]);
//					loc = indexOf(myText, target, pos);
//				}
//				myMap.put(target, follows);
			}
			if (i + myOrder < myText.length)
				myMap.get(target).add(myText[i+myOrder]);
				
			else
				myMap.put(target, new ArrayList<String>());
		}
	}
	public ArrayList<String> getFollows(WordGram kGram)
	{
		return myMap.get(kGram);
	}
	public void printHashMapInfo() 
	{
	    System.out.println("Number of keys in the HashMap: " +( myMap.size()+1));
	    int maxSize = 0;
	    List<WordGram> keysWithMaxSize = new ArrayList<>();
	    for (WordGram key : myMap.keySet()) {
		List<String> follows = myMap.get(key);
		int size = follows.size();
		if (size > maxSize) {
		    maxSize = size;
		    keysWithMaxSize.clear();
		    keysWithMaxSize.add(key);
		} else if (size == maxSize) {
		    keysWithMaxSize.add(key);
		}
	    }
	    System.out.println("Size of the largest value in the HashMap: " + maxSize);
	    System.out.println("Keys that have the maximum size value:");
	    System.out.println(keysWithMaxSize.toString());
//	    System.out.println(myMap.toString());
//	    for (WordGram key : keysWithMaxSize) {
//		System.out.println(key);
//	    }
	}

}



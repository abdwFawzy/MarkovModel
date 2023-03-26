import java.util.ArrayList;
import java.util.*;

public class MarkovWordTester {
    public void testIndexOf() {
        MarkovWord mw = new MarkovWord(2);
        String[] words = {"the", "quick", "brown", "fox", "jumps", "over", "the", "lazy", "dog"};
	mw.setTraining(Arrays.toString(words));
        WordGram target = new WordGram(words, 2, 2);
        int start = 0;
        int expected = 2;
        int actual = mw.indexOf(words, target, start);
        System.out.println("Expected: " + expected);
        System.out.println("Actual: " + actual);
        System.out.println(target.toString());
        System.out.println();
    }

    public void testGetFollows() {
        MarkovWord mw = new MarkovWord(2);
        mw.setTraining("the quick brown fox jumps brown fox over brown fox the lazy dog");
        WordGram kGram = new WordGram(new String[]{"brown", "fox"}, 0, 2);
        ArrayList<String> expected = new ArrayList<>();
        expected.add("jumps");
        int expectedSize = 1;
        ArrayList<String> actual = mw.getFollows(kGram);
        int actualSize = actual.size();
        System.out.println("Expected follows: " + expected);
        System.out.println("Actual follows: " + actual);
        System.out.println("Expected size: " + expectedSize);
        System.out.println("Actual size: " + actualSize);
        System.out.println();
    }
    public void testGetRandomText() {
	    MarkovWord mw = new MarkovWord(2);
	    mw.setRandom(42);
	    mw.setTraining("lazy dog the quick brown fox jumps over the lazy dog");
	    int numWords = 100;
	    String expected = "the quick brown fox jumps over the lazy dog the quick brown fox jumps over the lazy dog";
	    String actual = mw.getRandomText(numWords);
	    System.out.println("Expected random text: " + expected);
	    System.out.println("Actual random text: " + actual);
	    System.out.println();
    }
    public static void main(String[] args) {
        MarkovWordTester tester = new MarkovWordTester();
        tester.testIndexOf();
        tester.testGetFollows();
        tester.testGetRandomText();
    }
}


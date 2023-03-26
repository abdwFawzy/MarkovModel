public class WordGramTester {

    public static void main(String[] args) {
        testLength();
        testToString();
        testEquals();
        testShiftAdd();
    }

    public static void testLength() {
        WordGram wg = new WordGram(new String[]{"this", "is", "a", "test"}, 0, 4);
        int expected = 4;
        int actual = wg.length();
        System.out.println("testLength:");
        System.out.println("Expected: " + expected);
        System.out.println("Actual: " + actual);
    }

    public static void testToString() {
        WordGram wg = new WordGram(new String[]{"this", "is", "a", "test"}, 0, 4);
        String expected = "this is a test";
        String actual = wg.toString();
        System.out.println("testToString:");
        System.out.println("Expected: " + expected);
        System.out.println("Actual: " + actual);
    }

    public static void testEquals() {
        WordGram wg1 = new WordGram(new String[]{"this", "is", "a", "test"}, 0, 4);
        WordGram wg2 = new WordGram(new String[]{"this", "is", "a", "test"}, 0, 4);
        WordGram wg3 = new WordGram(new String[]{"this", "is", "not", "a", "test"}, 0, 5);
        boolean expected1 = true;
        boolean expected2 = false;
        boolean actual1 = wg1.equals(wg2);
        boolean actual2 = wg1.equals(wg3);
        System.out.println("testEquals:");
        System.out.println("Expected (wg1 equals wg2): " + expected1);
        System.out.println("Actual (wg1 equals wg2): " + actual1);
        System.out.println("Expected (wg1 equals wg3): " + expected2);
        System.out.println("Actual (wg1 equals wg3): " + actual2);
    }

    public static void testShiftAdd() {
	    WordGram wg = new WordGram(new String[]{"this", "is", "a", "test"}, 0, 4);
	    WordGram expected1 = new WordGram(new String[]{"is", "a", "test", "yes"}, 0, 4);
	    WordGram expected2 = new WordGram(new String[]{"is", "no", "a", "test"}, 0, 4);
	    WordGram expected3 = new WordGram(new String[]{"is", "not", "a", "test"}, 0, 4);
	    WordGram actual1 = wg.shiftAdd("yes");
	    WordGram actual2 = new WordGram(new String[]{wg.wordAt(1), "no", wg.wordAt(2), wg.wordAt(3), "yes"}, 0, 4);
	    System.out.println("testShiftAdd:");
	    System.out.println("Expected (shiftAdd with 'yes'): " + expected1);
	    System.out.println("Actual (shiftAdd with 'yes'): " + actual1);
	    System.out.println("Expected (shiftAdd with 'no' and shift): " + expected2);
	    System.out.println("Actual (shiftAdd with 'no' and shift): " + actual2);
    }
}


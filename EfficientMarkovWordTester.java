import java.util.ArrayList;
import java.util.HashMap;
import edu.duke.*;

public class EfficientMarkovWordTester {
    public void testHashMap() {
        trainingText = "this is a test yes this is really a test yes a test this is wow";
        emw.setTraining(trainingText);
        emw.buildMap();
        emw.printHashMapInfo();
    }
    
    public void testCompareMethods() {
        MarkovWord mw = new MarkovWord(3);
        EfficientMarkovWord emw = new EfficientMarkovWord(3);
        String filename = new FileResource().asString();
        int numChars = 100;
        int numTests = 3;
        long startTime, endTime;
        
        System.out.println("Running MarkovWord:");
        mw.setTraining(filename);
        startTime = System.nanoTime();
        for (int i = 0; i < numTests; i++) {
            String text = mw.getRandomText(numChars);
            System.out.println(text);
        }
        endTime = System.nanoTime();
        System.out.println("Elapsed time: " + (endTime - startTime) + " ns");
        
        System.out.println("Running EfficientMarkovWord:");
        emw.setTraining(filename);
	emw.setSeed(371);
        startTime = System.nanoTime();
        emw.buildMap();
        for (int i = 0; i < numTests; i++) {
            String text = emw.getRandomText(numChars);
            System.out.println(text);
        }
        endTime = System.nanoTime();
        System.out.println("Elapsed time: " + (endTime - startTime) + " ns");
    }
    
    public static void main(String[] args) {
        EfficientMarkovWordTester tester = new EfficientMarkovWordTester();
//       tester.testHashMap();
        tester.testCompareMethods();
    }
}


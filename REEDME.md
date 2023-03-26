# EfficientMarkovWord

EfficientMarkovWord is a Java program that generates random text based on a given input text using the Markov chain algorithm. 

## Usage

To use EfficientMarkovWord, simply download the source code and compile it using a Java compiler. Then, run the program with the following command:



Where `[input file]` is the path to the input text file, `[order]` is an integer representing the "order" of the Markov model, and `[output length]` is an integer representing the number of words in the output text.

## How it Works

EfficientMarkovWord works by building a hashmap that maps each WordGram of the given order to a list of words that follow that WordGram in the input text. The program then generates random text by starting with a randomly chosen WordGram and selecting a random word from the list of words that follow that WordGram. This process is repeated to generate the desired number of words in the output text. The program also includes methods for setting the random seed, training the model on new input text, and printing statistics about the generated hashmap.

## Additional Features

EfficientMarkovWord includes several additional features that make it a versatile and powerful tool for generating random text. These features include:

- Setting the random seed to generate deterministic output
- Training the model on new input text to improve the quality of the generated output
- Printing statistics about the generated hashmap to analyze the frequency of each WordGram and the words that follow them



## Acknowledgements

EfficientMarkovWord was inspired by the work of [Mark V. Shaney](https://en.wikipedia.org/wiki/Mark_V._Shaney) and [Tom Cormen](https://en.wikipedia.org/wiki/Introduction_to_Algorithms).


## Contributors

EfficientMarkovWord was created by [Your Name Here]. Contributions are welcome and encouraged! To contribute, please fork the repository and submit a pull request.

##Documentation for EfficientMarkovWordTester:

EfficientMarkovWordTester is a class that tests the implementation of the EfficientMarkovWord class, which generates random text based on a given input text using the Markov chain algorithm. The EfficientMarkovWordTester class includes two test methods: testHashMap() and testCompareMethods().

    testHashMap():

The testHashMap() method tests the buildMap() and printHashMapInfo() methods of the EfficientMarkovWord class. The method sets a sample training text, builds a hashmap using the EfficientMarkovWord class, and prints out statistics about the hashmap, including the number of keys, the largest size of any list of values, and the keys that have the largest list of values.

    testCompareMethods():

The testCompareMethods() method compares the performance of the MarkovWord and EfficientMarkovWord classes in generating random text. The method sets the order of both classes to 3 and uses a file resource as the training text. The method generates three random texts of 100 characters each using both classes and measures the elapsed time for each class. The method prints out the generated texts and the elapsed time for each class.

To run the EfficientMarkovWordTester class, create an instance of the class and call the testHashMap() or testCompareMethods() method. The main() method in the class calls the testCompareMethods() method by default, but the testHashMap() method can be called instead by uncommenting the appropriate line.

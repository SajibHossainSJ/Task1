import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.TreeMap;

public class WordCounter {
    public static void main(String[] args) {
        
        TreeMap<String, Integer> wordCounts = new TreeMap<>();

        // Read the text file
        try {
            File file = new File("input.txt"); 
            Scanner scanner = new Scanner(file);

            // Process each word in the file
            while (scanner.hasNext()) {
                String word = scanner.next().toLowerCase();
                // Remove punctuation marks
                word = word.replaceAll("[^a-zA-Z]", "");

                // Update word count in the TreeMap
                if (!word.isEmpty()) {
                    wordCounts.put(word, wordCounts.getOrDefault(word, 0) + 1);
                }
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            System.err.println("File not found!");
            e.printStackTrace();
        }

        // Display word counts for each unique word in alphabetical order
        for (String word : wordCounts.keySet()) {
            System.out.println(word + ": " + wordCounts.get(word));
        }
    }
}

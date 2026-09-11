package String_Operations.Assignment_problems;

import java.util.Scanner;
import java.util.*;

public class WordFrequencyReporter {
    static class WordCount {
        String word;
        int count;

        WordCount(String word, int count) {
            this.word = word;
            this.count = count;
        }
    }

    public static void printFilteredWordFrequency(String feedback) {
        List<String> stopWords = Arrays.asList("the", "was", "and", "a", "is", "of", "in");

        String normalized = feedback.toLowerCase();

        normalized = normalized.replace(".", "").replace(",", "");

        if(normalized.trim().isEmpty()) {
            return;
        }

        String[] words = normalized.trim().split("\\s+");

        List<WordCount> frequencyList = new ArrayList<>();

        for(String word : words) {
            if(stopWords.contains(word)) {
                continue;
            }

            boolean found = false;
            for(WordCount wc : frequencyList) {
                if(wc.word.equals(word)) {
                    wc.count++;
                    found = true;
                    break;
                }
            }

            if(!found) {
                frequencyList.add(new WordCount(word, 1));
            }
        }

        frequencyList.sort((a, b) -> Integer.compare(b.count, a.count));

        for(WordCount wc : frequencyList) {
            System.out.println(wc.word + ": " + wc.count);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a line: ");
        String line = sc.nextLine();

        printFilteredWordFrequency(line);

        sc.close();
    }
}

package ru.rsreu.ivchenko.collections.tools;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TextAnalyzer {
    List<String> sentencesList;

    public TextAnalyzer(List<String> sentencesList) {
        this.sentencesList = sentencesList;
    }

    public Set<String> getUniqueWordsInText() {
        Pattern pattern = Pattern.compile("\\w+", Pattern.UNICODE_CHARACTER_CLASS);
        Set<String> uniqueWords = new HashSet<>();
        for (String sentence : sentencesList) {
            Matcher matcher = pattern.matcher(sentence);
            while (matcher.find()) {
                uniqueWords.add(matcher.group().toLowerCase());
            }
        }
        return uniqueWords;
    }

    public int countUniqueWordsInText() {
        return getUniqueWordsInText().size();
    }

    public Set<String> getUniqueWordsAscendingLenght(Comparator comparator) {
        Set<String> uniqueWordsAscendingLenght = new TreeSet<>(comparator);
        Set<String> uniqueWords = getUniqueWordsInText();
        for (String word : uniqueWords) {
            uniqueWordsAscendingLenght.add(word);
        }
        return uniqueWordsAscendingLenght;
    }

    public Map<String, Integer> getUniqueWordsAndTheirCounts() {
        Map<String, Integer> uniqueWordsMap = new HashMap<>();
        for (String word : getUniqueWordsInText()) {
            int count = 0;
            Pattern pattern = Pattern.compile("\\b" + word + "\\b", Pattern.UNICODE_CASE | Pattern.CASE_INSENSITIVE);
            for (String sentence : sentencesList) {
                Matcher matcher = pattern.matcher(sentence);
                while (matcher.find()) {
                    count++;
                }
            }
            uniqueWordsMap.put(word, count);
        }
        return uniqueWordsMap;
    }

    public ArrayList<String> getReverseText() {
        ArrayList<String> sentencesList = (ArrayList<String>) ((ArrayList<String>) this.sentencesList).clone();
        Collections.reverse(sentencesList);
        return sentencesList;
    }

    private static int[] parseStringNumbers(String numbers) {
        String[] numbersStringArray = numbers.split(" ");
        int[] numbersIntArray = new int[numbersStringArray.length];
        for (int i = 0; i < numbersIntArray.length; i++) {
            numbersIntArray[i] = Integer.parseInt(numbersStringArray[i]);
        }
        return numbersIntArray;
    }

    public void printSentences(String numbers) {
        int[] sentencesNumber = parseStringNumbers(numbers);
        for (int number : sentencesNumber) {
            if (number > sentencesList.size() - 1) {
                System.out.println("Отсутствует строка с номером " + number);
            } else {
                System.out.println(sentencesList.get(number));
            }
        }
    }


}

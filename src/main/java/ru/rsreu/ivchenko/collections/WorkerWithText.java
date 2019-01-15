package ru.rsreu.ivchenko.collections;

import ru.rsreu.ivchenko.collections.dao.TextLoader;
import ru.rsreu.ivchenko.collections.dao.TextLoaderImpl;
import ru.rsreu.ivchenko.collections.tools.TextAnalyzer;

import java.util.List;

public class WorkerWithText {
    private static final String TEXT_SOURCE = "src/MyText";

    public static void main(String[] args) {
        TextLoader textLoader = new TextLoaderImpl();
        List<String> sentences = textLoader.getText(TEXT_SOURCE);
        TextAnalyzer analyzer = new TextAnalyzer(sentences);
        //Задание 1
        System.out.println("Количество уникальных слов в файле = " + analyzer.countUniqueWordsInText());
        //Задание 2
//        Set<String> uniqueWordsAscendingLenght = analyzer.getUniqueWordsAscendingLenght(new LenghtComparator());
//        for (String word : uniqueWordsAscendingLenght) {
//            System.out.println(word);
//        }
        //Задание 3
//        Map<String, Integer> uniqueWordsMap = analyzer.getUniqueWordsAndTheirCounts();
//        for (Map.Entry<String, Integer> item : uniqueWordsMap.entrySet()) {
//            System.out.printf("Слово '%s' встретилось %d раз\n", item.getKey(), item.getValue());
//        }
        //Задание 4
//        List<String> reverseText = analyzer.getReverseText();
//        for (String sentence : reverseText) {
//            System.out.println(sentence);
//        }
        //Задание 5
//        for (String sentence : new ReverseIterator<String>(sentences)) {
//            System.out.println(sentence);
//        }
        //Задание 6
//        System.out.println("Введите номера строк (через пробелы), которые необходимо вывести на экран:");
//        Scanner scanner = new Scanner(System.in);
//        String sentencesNumbers = scanner.nextLine();
//        analyzer.printSentences(sentencesNumbers);
    }
}

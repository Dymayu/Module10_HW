package task3;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class CountWords {
    // метод для підрахунку слів
    public static Map<String, Integer> couter() throws IOException {
        // створюємо мапу для зберігіння слів + каунтер
        Map<String, Integer> wordCountMap = new HashMap<>();
        // створюємо BufferedReader для зручного зчитування рядків з файла
        BufferedReader reader = new BufferedReader(new FileReader("words.txt"));
        // розбиваємо рядок на слова через пробіл і записуємо в масив
        String line;
        while ((line = reader.readLine()) != null) {
            String[] lineArr = line.split("\\s+");
            // проходиом по масиву слів і записуємо в мапу
            for (String word : lineArr) {
                if (!word.isEmpty()) {
                    // Додавання слова до мапи, збільшуючи його частоту. Якщо слово вже присутнє в мапі, збільшуємо частоту на 1, в іншому випадку додаємо слово з частотою 1.
                    wordCountMap.put(word, wordCountMap.getOrDefault(word, 0) + 1);
                }
            }
        }
        return wordCountMap;
    }
    public static void displayWordCount(Map<String, Integer> wordCountMap){
        // Створюємо список з елементами мапи
        List<Map.Entry<String, Integer>> entryList = new ArrayList<>(wordCountMap.entrySet());

        // Сортуємо список за значеннями (в порядку спадання)
        entryList.sort(Collections.reverseOrder(Map.Entry.comparingByValue()));

        // Виводимо відсортовані пари ключ-значення
        for (Map.Entry<String, Integer> entry : entryList) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }

    public static void main(String[] args) throws IOException {
        displayWordCount(couter());
    }
}

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class ValuesCounter {

    // Создаем HashMap
    private static HashMap<Character, Integer> libraryHashMap = new HashMap<>();

    public HashMap<Character, Integer> getHashMap() {
        return libraryHashMap;
    }

    public void setHashMap(HashMap<Character, Integer> hashMap) {
        this.libraryHashMap = hashMap;
    }

    // Заполнение мапы символами
    private void fillLibraryWithLetters() {
        for (char letter = 'a'; letter <= 'z'; letter++) {
            this.libraryHashMap.put(letter, 0);
        }
        libraryHashMap.put(' ', 0);
    }

    // Чтение сообщения из файла и занесение символов с подсчетом повторений в нашу мапу
    private HashMap<Character, Integer> readFileWithCountValuesLetters(HashMap<Character, Integer> libraryHashMap, String fileName) {

        // Чтение строк посимвольно из файла
        try (Scanner scanner = new Scanner(new File(fileName))) {
            while (scanner.hasNext()) {
                String line = scanner.nextLine();
                for (int i = 0; i < line.length(); i++) {
                    char c = line.charAt(i);
                    // Проверка, что символ находится в библиотеке
                    if (libraryHashMap.containsKey(c)) { //|| c == ' ') {
                        // Преобразуем символ к нижнему регистру
                        c = Character.toLowerCase(c);
                        int value = libraryHashMap.get(c);
                        libraryHashMap.put(c, value + 1);
                    }
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        System.out.println("Содержимое HashMap после чтения файла: " + libraryHashMap);
        return libraryHashMap;
    }

    // Сортировка ключей мапы по значению в порядке убывания
    private LinkedHashMap<Character, Integer> sort(HashMap<Character, Integer> libraryHashMap) {

        // Создаем список записей из HashMap
        List<Map.Entry<Character, Integer>> list = new ArrayList<>(libraryHashMap.entrySet());

        // Сортируем список по значениям
        Collections.sort(list, new Comparator<Map.Entry<Character, Integer>>() {
            public int compare(Map.Entry<Character, Integer> o1, Map.Entry<Character, Integer> o2) {
                // Сначала сравниваем значения
                int valueCompare = o2.getValue().compareTo(o1.getValue());
                // Если значения равны, то сравниваем ключи
                if (valueCompare == 0) {
                    return o1.getKey().compareTo(o2.getKey());
                }
                return valueCompare;
            }
        });

        // Создаем LinkedHashMap на основе отсортированного списка
        LinkedHashMap<Character, Integer> sortedLibraryLinkedHashMap = new LinkedHashMap<>();
        for (Map.Entry<Character, Integer> entry : list) {
            // Проверяем, что значение не нулевое, и только тогда добавляем его в отсортированную Map
            if (entry.getValue() != null && entry.getValue() != 0)
                sortedLibraryLinkedHashMap.put(entry.getKey(), entry.getValue());
        }
        System.out.println("Содержимое HashMap после сортировки по значениям: " + sortedLibraryLinkedHashMap);
        return sortedLibraryLinkedHashMap;
    }

    // Публичный метод подсчета символов в отсортированном порядке
    public LinkedHashMap<Character, Integer> countSortValues(String fileName) {
        fillLibraryWithLetters();
        return sort(readFileWithCountValuesLetters(this.libraryHashMap, fileName));
    }
}

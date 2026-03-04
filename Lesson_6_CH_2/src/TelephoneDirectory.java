
import java.util.*;

public class TelephoneDirectory {
    private Map<String, List<String>> map = new HashMap<>();

    public void add(String surname, String phoneNumber) {
        // Если ключ уже есть, добавляем номер в существующий список, иначе создаём новый список
        map.computeIfAbsent(surname, k -> new ArrayList<>()).add(phoneNumber);
    }

    public List<String> get(String surname) {
        return map.get(surname);
    }

    public void printAll() {
        for (Map.Entry<String, List<String>> entry : map.entrySet()) {
            System.out.println(entry.getKey() + " -> " + entry.getValue());
        }
    }
}
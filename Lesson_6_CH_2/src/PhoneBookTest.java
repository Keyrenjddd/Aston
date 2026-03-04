import java.util.List;

public class PhoneBookTest {
    public static void main(String[] args) {
        TelephoneDirectory directory = new TelephoneDirectory();

        directory.add("Суслов", "111-22-33");
        directory.add("Чикин", "222-33-44");
        directory.add("Суслов", "333-44-55");
        directory.add("Вахтан", "444-55-66");
        directory.add("Суслов", "555-66-77");

        System.out.println("Все записи:");
        directory.printAll();

        System.out.println("\nТелефоны Суслова:");
        List<String> syslovPhones = directory.get("Суслов");
        if (syslovPhones != null) {
            for (String phone : syslovPhones) {
                System.out.println(phone);
            }
        } else {
            System.out.println("Не найдено");
        }

        System.out.println("\nТелефоны Чикина:");
        List<String> chikinPhones = directory.get("Чикин");
        if (chikinPhones != null) {
            for (String phone : chikinPhones) {
                System.out.println(phone);
            }
        } else {
            System.out.println("Не найдено");
        }

        System.out.println("\nТелефоны неизвестной фамилии:");
        List<String> unknownPhones = directory.get("Неизвестный");
        System.out.println(unknownPhones == null ? "Не найдено" : unknownPhones);
    }
}
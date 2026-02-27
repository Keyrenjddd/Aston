public class Main {
    public static void main(String[] args) {
        // === Часть 1: животные и счётчики ===
        System.out.println("=== Демонстрация животных ===");
        Dog dog1 = new Dog("Очень хороший мальчик");
        Dog dog2 = new Dog("Очень хорошая девочка");
        Cat cat1 = new Cat("Блювун");
        Cat cat2 = new Cat("Лизоблюд");
        Cat cat3 = new Cat("Кокс");

        dog1.run(450);
        dog1.swim(5);
        dog2.run(600); // превышение
        cat1.run(150);
        cat1.swim(10);

        System.out.println("\n=== Статистика ===");
        System.out.println("Всего животных: " + Animal.animalCount);
        System.out.println("Собак: " + Animal.dogCount);
        System.out.println("Котов: " + Animal.catCount);

        // === Часть 2: коты и миска ===
        System.out.println("\n=== Кормление котов ===");
        // Создаём массив котов
        Cat[] cats = {cat1, cat2, cat3};
        // Создаём миску с 15 едой
        Bowl bowl = new Bowl(15);

        // Каждый кот пытается съесть разное количество
        cat1.eat(bowl, 5);
        cat2.eat(bowl, 7);
        cat3.eat(bowl, 5); // должно не хватить, т.к. останется 3

        System.out.println("\n=== Результат сытости ===");
        for (Cat cat : cats) {
            System.out.println(cat.name + " сыт? " + (cat.isSatiety() ? "да" : "нет"));
        }

        // Добавляем еду в миску
        bowl.addFood(10);
        // Кормим голодную тупую кису
        cat3.eat(bowl, 5);
        System.out.println(cat3.name + " сыт? " + (cat3.isSatiety() ? "да" : "нет"));
    }
}
public abstract class Animal {
    protected String name;

    // Статические счётчики
    public static int animalCount = 0;
    public static int dogCount = 0;
    public static int catCount = 0;

    public Animal(String name) {
        this.name = name;
        animalCount++;  // при создании любого животного увеличиваем общий счётчик
    }

    // Абстрактные методы, которые обязаны реализовать потомки
    public abstract void run(int distance);
    public abstract void swim(int distance);
}
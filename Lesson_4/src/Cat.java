public class Cat extends Animal {
    private static final int MAX_RUN = 200;
    private boolean satiety; // сытость (true - сыт)

    public Cat(String name) {
        super(name);
        catCount++; // увеличиваем счётчик котов
        this.satiety = false; // по умолчанию голоден
    }

    @Override
    public void run(int distance) {
        if (distance <= MAX_RUN) {
            System.out.println(name + " пробежал " + distance + " м.");
        } else {
            System.out.println(name + " не может пробежать " + distance + " м (максимум " + MAX_RUN + ").");
        }
    }

    @Override
    public void swim(int distance) {
        System.out.println(name + " не умеет плавать!");
    }

    // Метод для еды из миски
    public void eat(Bowl bowl, int amount) {
        if (bowl.decreaseFood(amount)) {
            satiety = true;
            System.out.println(name + " поел(а) " + amount + " еды и теперь сыт(а).");
        } else {
            System.out.println(name + " не поел(а): в миске недостаточно еды.");
        }
    }

    public boolean isSatiety() {
        return satiety;
    }
}
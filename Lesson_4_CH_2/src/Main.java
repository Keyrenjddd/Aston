public class Main {
    public static void main(String[] args) {
        System.out.println("=== Геометрические фигуры ===");

        // Создаём объекты фигур
        Shape circle = new Circle(10, Color.RED, Color.BLACK);
        Shape rectangle = new Rectangle(6, 9, Color.BLUE, Color.GREEN);
        Shape triangle = new Triangle(2, 4, 5, Color.YELLOW, Color.ORANGE);

        // Выводим информацию о каждой фигуре, используя default-метод интерфейса
        circle.printFullInfo();
        rectangle.printFullInfo();
        triangle.printFullInfo();
    }
}
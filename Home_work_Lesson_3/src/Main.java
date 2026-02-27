public class Main {
    public static void main(String[] args) {
        // товары
        Product[] productsArray = new Product[5];

        productsArray[0] = new Product("Samsung S25 Ultra", "01.02.2025",
                "Samsung", "Корея", 5599.99, true);
        productsArray[1] = new Product("iPhone 15 Pro", "15.03.2024",
                "Apple", "США", 1299.99, false);
        productsArray[2] = new Product("Xiaomi Mi 14", "10.01.2025",
                "Xiaomi", "Китай", 799.99, true);
        productsArray[3] = new Product("Sony WH-1000XM5", "20.11.2024",
                "Sony", "Япония", 349.99, false);
        productsArray[4] = new Product("MacBook Air M2", "05.12.2024",
                "Apple", "США", 1499.99, true);

        System.out.println("=== Товары ===");
        for (Product product : productsArray) {
            product.displayInfo();
        }

        // парк и аттракционы
        System.out.println("=== Аттракционы ===");
        Park centralPark = new Park("Центральный парк");

        Park.Attraction attraction1 = centralPark.new Attraction("Американские горки", "10:00-21:00", 400.0);
        Park.Attraction attraction2 = centralPark.new Attraction("Колесо обозрения", "10:00-23:00", 350.0);
        Park.Attraction attraction3 = centralPark.new Attraction("Комната страха", "12:00-20:00", 150.0);

        System.out.println("Парк: " + centralPark.getParkName());
        attraction1.displayInfo();
        attraction2.displayInfo();
        attraction3.displayInfo();
    }
}
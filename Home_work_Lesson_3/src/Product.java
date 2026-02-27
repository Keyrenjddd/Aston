public class Product {
    String name;
    String productionDate;
    String manufacturer;
    String country;
    double price;
    boolean isBooked;

    public Product(String name, String productionDate, String manufacturer,
                   String country, double price, boolean isBooked) {
        this.name = name;
        this.productionDate = productionDate;
        this.manufacturer = manufacturer;
        this.country = country;
        this.price = price;
        this.isBooked = isBooked;
    }

    public void displayInfo() {
        System.out.println("Название: " + name);
        System.out.println("Дата производства: " + productionDate);
        System.out.println("Производитель: " + manufacturer);
        System.out.println("Страна: " + country);
        System.out.println("Цена: " + price);
        System.out.println("Забронирован: " + (isBooked ? "да" : "нет"));
        System.out.println("------------------------");
    }
}
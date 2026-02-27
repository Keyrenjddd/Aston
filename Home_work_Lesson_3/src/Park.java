public class Park {
    public class Attraction {
        private String name;
        private String workingHours;
        private double price;

        public Attraction(String name, String workingHours, double price) {
            this.name = name;
            this.workingHours = workingHours;
            this.price = price;
        }

        public void displayInfo() {
            System.out.println("Аттракцион: " + name);
            System.out.println("Время работы: " + workingHours);
            System.out.println("Цена: " + price);
            System.out.println("------------------------");
        }
    }

    private String parkName;

    public Park(String parkName) {
        this.parkName = parkName;
    }

    public String getParkName() {
        return parkName;
    }
}
public class Bowl {
    private int foodAmount; // текущее количество еды в миске

    public Bowl(int foodAmount) {
        this.foodAmount = foodAmount;
    }

    // Уменьшаем еду на amount, если хватает
    public boolean decreaseFood(int amount) {
        if (amount <= foodAmount) {
            foodAmount -= amount;
            return true;
        }
        return false;
    }

    // Добавляем еду
    public void addFood(int amount) {
        if (amount > 0) {
            foodAmount += amount;
            System.out.println("В миску добавлено " + amount + " еды. Теперь в миске: " + foodAmount);
        }
    }

    public int getFoodAmount() {
        return foodAmount;
    }
}
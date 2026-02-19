import java.util.Arrays;

public class Lesson_2 {

    public static void main(String[] args) {
        System.out.println("=== Задание 1: printThreeWords() ===");
        printThreeWords();

        System.out.println("\n=== Задание 2: checkSumSign() ===");
        checkSumSign();

        System.out.println("\n=== Задание 3: printColor() ===");
        printColor();

        System.out.println("\n=== Задание 4: compareNumbers() ===");
        compareNumbers();

        System.out.println("\n=== Задание 5: isSumInRange() ===");
        System.out.println("5 + 7 = " + (5 + 7) + " -> " + isSumInRange(5, 7));
        System.out.println("15 + 6 = " + (15 + 6) + " -> " + isSumInRange(15, 6));

        System.out.println("\n=== Задание 6: printSign() ===");
        printSign(-3);
        printSign(0);
        printSign(8);

        System.out.println("\n=== Задание 7: isNegative() ===");
        System.out.println("-5 отрицательное? " + isNegative(-5));
        System.out.println("10 отрицательное? " + isNegative(10));

        System.out.println("\n=== Задание 8: printStringMultipleTimes() ===");
        printStringMultipleTimes("Привет!", 3);

        System.out.println("\n=== Задание 9: isLeapYear() ===");
        System.out.println("2000 високосный? " + isLeapYear(2000));
        System.out.println("1900 високосный? " + isLeapYear(1900));
        System.out.println("2024 високосный? " + isLeapYear(2024));
        System.out.println("2023 високосный? " + isLeapYear(2023));

        System.out.println("\n=== Задание 10: invertArray() ===");
        invertArray();

        System.out.println("\n=== Задание 11: fillArray() ===");
        fillArray();

        System.out.println("\n=== Задание 12: multiplyLessThanSix() ===");
        multiplyLessThanSix();

        System.out.println("\n=== Задание 13: fillDiagonals() ===");
        fillDiagonals();

        System.out.println("\n=== Задание 14: createArray() ===");
        int[] newArray = createArray(7, 42);
        System.out.println("Массив длины 7 со значением 42: " + Arrays.toString(newArray));
    }

    // Задание 1
    public static void printThreeWords() {
        System.out.println("Orange");
        System.out.println("Banana");
        System.out.println("Apple");
    }

    // Задание 2
    public static void checkSumSign() {
        int a = 10;
        int b = -5;
        int sum = a + b;
        if (sum >= 0) {
            System.out.println("Сумма положительная");
        } else {
            System.out.println("Сумма отрицательная");
        }
    }

    // Задание 3
    public static void printColor() {
        int value = 75;
        if (value <= 0) {
            System.out.println("Красный");
        } else if (value <= 100) {
            System.out.println("Жёлтый");
        } else {
            System.out.println("Зелёный");
        }
    }

    // Задание 4
    public static void compareNumbers() {
        int a = 7;
        int b = 12;
        if (a >= b) {
            System.out.println("a >= b");
        } else {
            System.out.println("a < b");
        }
    }

    // Задание 5
    public static boolean isSumInRange(int a, int b) {
        int sum = a + b;
        return sum >= 10 && sum <= 20;
    }

    // Задание 6
    public static void printSign(int num) {
        if (num >= 0) {
            System.out.println("Число положительное");
        } else {
            System.out.println("Число отрицательное");
        }
    }

    // Задание 7
    public static boolean isNegative(int num) {
        return num < 0;
    }

    // Задание 8
    public static void printStringMultipleTimes(String str, int count) {
        for (int i = 0; i < count; i++) {
            System.out.println(str);
        }
    }

    // Задание 9
    public static boolean isLeapYear(int year) {
        if (year % 400 == 0) {
            return true;
        } else if (year % 100 == 0) {
            return false;
        } else if (year % 4 == 0) {
            return true;
        } else {
            return false;
        }
    }

    // Задание 10
    public static void invertArray() {
        int[] arr = {1, 1, 0, 0, 1, 0, 1, 1, 0, 0};
        System.out.println("Исходный массив: " + Arrays.toString(arr));
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (arr[i] == 0) ? 1 : 0;
        }
        System.out.println("После замены:  " + Arrays.toString(arr));
    }

    // Задание 11
    public static void fillArray() {
        int[] arr = new int[100];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = i + 1;
        }
        System.out.println("Массив от 1 до 100: " + Arrays.toString(arr));
    }

    // Задание 12
    public static void multiplyLessThanSix() {
        int[] arr = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        System.out.println("Исходный массив: " + Arrays.toString(arr));
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < 6) {
                arr[i] *= 2;
            }
        }
        System.out.println("После умножения: " + Arrays.toString(arr));
    }

    // Задание 13
    public static void fillDiagonals() {
        int size = 5;
        int[][] matrix = new int[size][size];
        for (int i = 0; i < size; i++) {
            matrix[i][i] = 1;               // главная диагональ
            matrix[i][size - 1 - i] = 1;    // побочная диагональ
        }
        System.out.println("Матрица " + size + "x" + size + " с единицами на обеих диагоналях:");
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    // Задание 14
    public static int[] createArray(int len, int initialValue) {
        int[] arr = new int[len];
        for (int i = 0; i < len; i++) {
            arr[i] = initialValue;
        }
        return arr;
    }
}
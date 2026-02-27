public class Triangle implements Shape {
    private double sideA, sideB, sideC;
    private Color fillColor;
    private Color borderColor;

    public Triangle(double sideA, double sideB, double sideC, Color fillColor, Color borderColor) {
        // Проверка на существование треугольника
        if (sideA + sideB <= sideC || sideA + sideC <= sideB || sideB + sideC <= sideA) {
            throw new IllegalArgumentException("Треугольник с такими сторонами не существует");
        }
        this.sideA = sideA;
        this.sideB = sideB;
        this.sideC = sideC;
        this.fillColor = fillColor;
        this.borderColor = borderColor;
    }

    @Override
    public double getPerimeter() {
        return sideA + sideB + sideC;
    }

    @Override
    public double getArea() {
        double p = getPerimeter() / 2;
        return Math.sqrt(p * (p - sideA) * (p - sideB) * (p - sideC));
    }

    @Override
    public String getFillColor() {
        return fillColor.toString();
    }

    @Override
    public String getBorderColor() {
        return borderColor.toString();
    }
}
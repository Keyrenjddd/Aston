public class Rectangle implements Shape {
    private double length;
    private double width;
    private Color fillColor;
    private Color borderColor;

    public Rectangle(double length, double width, Color fillColor, Color borderColor) {
        this.length = length;
        this.width = width;
        this.fillColor = fillColor;
        this.borderColor = borderColor;
    }

    @Override
    public double getPerimeter() {
        return 2 * (length + width);
    }

    @Override
    public double getArea() {
        return length * width;
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
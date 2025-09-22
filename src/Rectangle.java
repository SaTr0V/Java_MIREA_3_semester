public class Rectangle extends GeometricObject {
    private double width;
    private double height;

    public Rectangle() { }
    public Rectangle(double width, double height) {
        this.width = width;
        this.height = height;
    }
    public Rectangle(double width, double height, String color, boolean filled) {
        this.width = width;
        this.height = height;
        setColor(color);
        setFilled(filled);
    }

    public double getWidth() { return width; }
    public double getHeight() { return width; }
    public double getPerimeter() { return 2 * (width + height); }
    public double getArea() { return width * height; }

    @Override
    public String toString() {
        return "Rectangle: width = " + width + ", height = " + height +
                "\nArea: " + String.format("%.2f", getArea()) +
                "\nPerimeter: " + String.format("%.2f", getPerimeter()) +
                "\n" + super.toString();
    }
}

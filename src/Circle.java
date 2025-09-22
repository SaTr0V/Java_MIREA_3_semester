public class Circle extends GeometricObject {
    private double radius;

    public Circle() { }

    public Circle(double radius) { this.radius = radius; }

    public Circle(double radius, String color, boolean filled) {
        this.radius = radius;
        setColor(color);
        setFilled(filled);
    }

    public double getRadius() { return radius; }
    public void setRadius(double radius) { this.radius = radius; }

    public double getDiameter() { return radius * 2; }

    public double getPerimeter() { return 2 * Math.PI * radius; }

    public double getArea() { return Math.PI * radius * radius; }

    public void printCircle() {
        System.out.println("Circle: radius = " + radius + ", diameter = " + String.format("%.2f", getDiameter()) +
                "\nArea: " + String.format("%.2f", getArea()) +
                "\nPerimeter: " + String.format("%.2f", getPerimeter()) +
                "\n" + super.toString());
    }
}
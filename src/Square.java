public class Square extends GeometricObject implements Colorable {
    private double side;

    public Square() {
        side = 0;
    }

    public Square(double side) {
        this.side = side;
    }

    public Square(double side, String color, boolean filled) {
        super(color, filled);
        this.side = side;
    }

    // Геттер и сеттер для стороны
    public double getSide() { return side; }

    public void setSide(double side) { this.side = side; }

    // Реализация метода howToColor() из интерфейса Colorable
    @Override
    public void howToColor() {
        System.out.println("Раскрасьте все четыре стороны");
    }

    @Override
    public double getArea() {
        return side * side;
    }

    @Override
    public double getPerimeter() {
        return 4 * side;
    }

    @Override
    public String toString() {
        return "Square: side = " + side +
                ", area = " + String.format("%.2f", getArea()) +
                ", perimeter = " + String.format("%.2f", getPerimeter()) +
                "\n" + super.toString();
    }
}

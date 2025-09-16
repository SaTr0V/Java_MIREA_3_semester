public class Triangle extends GeometricObject {
    private double side1 = 1.0;
    private double side2 = 1.0;
    private double side3 = 1.0;

    public Triangle() { };

    public Triangle(double side1, double side2, double side3) throws IllegalTriangleException {
        double max_side = Math.max(Math.max(side1, side2), side3);
        if (max_side >= (side1 + side2 + side3) - max_side) {  // проверка неравенства треугольника
            throw new IllegalTriangleException("Not able to create this triangle." +
                    " The biggest side must be less than a sum of other two.");
        }
        this.side1 = side1;
        this.side2 = side2;
        this.side3 = side3;
    }

    public double getSide1() { return side1; }
    public double getSide2() { return side2; }
    public double getSide3() { return side3; }

    public double getArea() {
        double p = (side1 + side2 + side3) / 2;

        return Math.sqrt(p * (p - side1) * (p - side2) * (p - side3));
    }

    public double getPerimeter() {
        return side1 + side2 + side3;
    }

    @Override
    public String toString() {
        return "Triangle: side1 = " + side1 + ", side2 = " + side2 + ", side3 = " + side3 +
                "\nArea: " + String.format("%.2f", getArea()) +
                "\nPerimeter: " + String.format("%.2f", getPerimeter()) +
                "\n" + super.toString();
    }
}

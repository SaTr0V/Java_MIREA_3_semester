public abstract class GeometricObject implements Comparable<GeometricObject> {
    private String color = "No color";
    private boolean filled;
    private java.util.Date dateCreated;

    // Конструктор по умолчанию
    protected GeometricObject() {
        dateCreated = new java.util.Date();
    }

    // Цветной и заполненный геометрический объект
    protected GeometricObject(String color, boolean filled) {
        dateCreated = new java.util.Date();
        this.color = color;
        this.filled = filled;
    }

    // Геттеры и сеттеры
    public String getColor() { return color; }
    public void setColor(String color) { this.color = color; }

    public boolean isFilled() { return filled; }
    public void setFilled(boolean filled) { this.filled = filled; }

    public java.util.Date getDateCreated() { return dateCreated; }

    @Override
    public String toString() {
        return "Created on " + dateCreated +
                "\nColor: " + color + " and filled: " + filled;
    }

    // Абстрактные методы получения площади и периметра
    public abstract double getArea();
    public abstract double getPerimeter();

    // Реализация метода compareTo из стандартного интерфейса Comparable
    @Override
    public int compareTo(GeometricObject other) {
        return Double.compare(this.getArea(), other.getArea());
    }

    // Статический метод max
    public static GeometricObject max(GeometricObject obj1, GeometricObject obj2) {
        if (obj1.compareTo(obj2) > 0) {
            return obj1;
        } else {
            return obj2;
        }
    }

    // Дополнительный статический метод для вывода информации
    public static void printMax(GeometricObject obj1, GeometricObject obj2) {
        GeometricObject maxObj = max(obj1, obj2);

        if (obj1.getArea() == obj2.getArea()) {
            System.out.println("The objects are equally as big (area = " + obj1.getArea() + ")");
        } else if (maxObj == obj1) {
            System.out.println("The first object (area = " + obj1.getArea() + ")" +
                    " is bigger than the second object (area = " + obj2.getArea() + ")");
        } else {
            System.out.println("The second object (area = " + obj2.getArea() + ")" +
                    " is bigger than the first object (area = " + obj1.getArea() + ")");
        }
    }
}


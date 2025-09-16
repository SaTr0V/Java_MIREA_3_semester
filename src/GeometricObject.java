public abstract class GeometricObject {
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
}


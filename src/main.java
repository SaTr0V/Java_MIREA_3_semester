import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        System.out.println("TEST PROGRAM");

        // Массив из пяти GeometricObject
        GeometricObject[] shapes = new GeometricObject[5];

        shapes[0] = new Square(5.0, "Red", true);
        shapes[1] = new Circle(3.0, "Blue", false);
        shapes[2] = new Rectangle(4.0, 6.0, "Green", true);
        shapes[3] = new Square(2.5, "Yellow", false);
        try {
            shapes[4] = new Triangle(3.0, 4.0, 5.0);
        }
        catch (IllegalTriangleException e) {
            System.out.println("Error: " + e.getMessage());
            System.exit(-1);
        }

        for (int i = 0; i < shapes.length; i++) {
            System.out.println("\nObject " + (i + 1));
            System.out.println("Area: " + String.format("%.2f", shapes[i].getArea()));
            System.out.println("Type: " + shapes[i].getClass().getSimpleName());

            // Проверка, реализует ли объект интерфейс Colorable
            if (shapes[i] instanceof Colorable) {
                System.out.print("How to color: ");
                ((Colorable) shapes[i]).howToColor();
            }
            else {
                System.out.println("This object is not colorable");
            }
        }
    }
}

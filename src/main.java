import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        System.out.println("TEST PROGRAM");

        Triangle triangle = null;  // инициализация объекта до конструкции if...else, иначе ошибка

        System.out.println("Do you wish to create your own triangle or use a default one?\n" +
                "Type 1 to create a triangle.\n" +
                "Type 2 to use a default triangle.");
        Scanner in = new Scanner(System.in);
        String cmd = in.nextLine();

        if (cmd.equalsIgnoreCase("1")) {
            System.out.print("Enter side 1 length: ");
            double side1 = in.nextDouble();

            System.out.print("Enter side 2 length: ");
            double side2 = in.nextDouble();

            System.out.print("Enter side 3 length: ");
            double side3 = in.nextDouble();

            try {
                triangle = new Triangle(side1, side2, side3);

                in.nextLine();  // очистка буфера после nextDouble
            }
            catch (IllegalTriangleException e) {
                System.out.println("Error: " + e.getMessage());
                System.exit(-1);
            }
        }
        else if (cmd.equalsIgnoreCase("no")) {
            triangle = new Triangle();
        }

        System.out.println("The triangle is successfully created!");

        System.out.println("\nDo you want to fill the triangle with a color? (yes/no)");
        cmd = in.nextLine();

        if (cmd.equalsIgnoreCase("yes")) {
            triangle.setFilled(true);  // установка заполненности filled на true

            System.out.print("Enter new color: ");
            String color = in.nextLine();
            triangle.setColor(color);
        }

        System.out.println("\n" + triangle.toString() + "\n");

        // Круги
        Circle circle_1 = new Circle(15);
        circle_1.printCircle();
        System.out.println();

        Circle circle_2 = new Circle(5, "Green", true);
        circle_2.printCircle();
        System.out.println();

        // Сравнение
        GeometricObject.printMax(circle_1, circle_2);

        System.out.println();

        // Сравнение прямоугольников
        Rectangle rectangle_1 = new Rectangle(2, 5);
        System.out.println(rectangle_1.toString() + "\n");

        Rectangle rectangle_2 = new Rectangle(10, 3);
        System.out.println(rectangle_2.toString() + "\n");

        GeometricObject.printMax(rectangle_1, rectangle_2);

        // Сравнение "сравниваемых" кругов
        ComparableCircle comp_1 = new ComparableCircle(2);
        ComparableCircle comp_2 = new ComparableCircle(4);

        int result1 = comp_1.compareTo(comp_2);
        if (result1 > 0) {
            System.out.println("Comparable circle 1 (area = " + comp_1.getArea() + ")" +
                    " is bigger than comparable circle 2 (area = " + comp_2.getArea() + ")");
        }
        else if (result1 < 0) {
            System.out.println("Comparable circle 2 (area = " + comp_2.getArea() + ")" +
                    " is bigger than comparable circle 1 (area = " + comp_1.getArea() + ")");
        }
        else {
            System.out.println("The circles are equally as big");
        }

        // Сравнение круга и прямоугольника
        int result2 = comp_1.compareTo(rectangle_1);
        if (result2 > 0) {
            System.out.println("Comparable circle (area = " + comp_1.getArea() + ")" +
                                " is bigger than the rectangle (area = " + rectangle_1.getArea() + ")");
        }
        else if (result2 < 0) {
            System.out.println("The rectangle (area = " + rectangle_1.getArea() + ")" +
                    " is bigger than the comparable circle (area = " + comp_1.getArea() + ")");
        }
        else {
            System.out.println("The circle and the rectangle are equally as big");
        }
    }
}

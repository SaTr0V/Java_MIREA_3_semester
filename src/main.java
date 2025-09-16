import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        System.out.println("TRIANGLE PROGRAM");

        Triangle triangle;  // объявление объекта до конструкции if...else, иначе будет невозможно с ним работать

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

            double max_side = Math.max(Math.max(side1, side2), side3);
            if (max_side >= (side1 + side2 + side3) - max_side) {
                System.out.println("Not able to create this triangle." +
                        " The biggest side must be less than a sum of other two.");

                System.exit(-1);
            }

            triangle = new Triangle(side1, side2, side3);
        } else {
            triangle = new Triangle();
        }

        in.nextLine();  // очистка буфера

        System.out.println("The triangle is successfully created!");

        System.out.println("\nDo you want to fill the triangle with a color? (yes/no)");
        cmd = in.nextLine();

        if (cmd.equalsIgnoreCase("yes")) {
            triangle.setFilled(true);  // установка заполненности filled на true

            System.out.print("Enter new color: ");
            String color = in.nextLine();
            triangle.setColor(color);
        }

        System.out.println(triangle.toString());
    }
}

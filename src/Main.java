import java.util.Scanner;

public class Main {
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);

        System.out.print("Model: ");
        String model = in.nextLine();

        System.out.print("License: ");
        String license = in.nextLine();

        System.out.print("Color: ");
        String color = in.nextLine();

        System.out.print("Year: ");
        int year = in.nextInt();

        System.out.println();
        System.out.println("------------------------------------------------");

        Car car_1 = new Car(model, license, color, year);
        Car car_2 = new Car();
        Car car_3 = new Car(color);

        System.out.println("Do you wish to change one of the properties? (yes/no)");

        in.nextLine();
        String cmd = in.nextLine();
        if (cmd.equalsIgnoreCase("yes")) {
            System.out.println("Choose the property you wish to change: model, license, color, year.");
            cmd = in.nextLine();
            car_1.Getter(cmd);
        }
        else if (cmd.equalsIgnoreCase("no")) {
            System.out.println("End.");
        }
        else {
            System.out.println("Unknown command.");
        }
    }
}
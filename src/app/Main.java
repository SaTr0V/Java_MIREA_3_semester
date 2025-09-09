package app;

import vehicles.Car;
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

        car_1.setEngineType();
        System.out.println("The car's engine type is " + car_1.getEngineType());
    }
}
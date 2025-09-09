package vehicles;

import java.util.Scanner;

public class Car {
    String model = "Mazda";
    String license = "М999ММ";
    String color = "Dark-Blue";
    int year = 2024;

    private String ownerName;
    private String insuranceNumber;
    protected String engineType;

    public Car() {
        To_String();
    }

    public Car(String model, String license, String color, int year) {
        this.model = model;
        this.license = license;
        this.color = color;
        this.year = year;

        To_String();
    }

    public Car(String color) {
        this.color = color;

        To_String();
    }

    public void To_String() {
        System.out.println("Model: " + this.model);
        System.out.println("License: " + this.license);
        System.out.println("Color: " + this.color);
        System.out.println("year: " + this.year);

        System.out.println("------------------------------------------------");
    }

    public void Setter(String cmd) {
        Scanner in = new Scanner(System.in);

        if (cmd.equalsIgnoreCase("year")) {
            System.out.print("New value of year: ");
            int changed_property = in.nextInt();

            this.year = changed_property;
            System.out.println("The change was successful!");
        }
        else if (cmd.equalsIgnoreCase("model")) {
            System.out.print("New model: ");
            String changed_property = in.nextLine();

            this.model = changed_property;
            System.out.println("The change was successful!");
        }
        else if (cmd.equalsIgnoreCase("license")) {
            System.out.print("New license: ");
            String changed_property = in.nextLine();

            this.license = changed_property;
            System.out.println("The change was successful!");
        }
        else if (cmd.equalsIgnoreCase("color")) {
            System.out.print("New color: ");
            String changed_property = in.nextLine();

            this.color = changed_property;
            System.out.println("The change was successful!");
        }
        else {
            System.out.println("Unknown command. Changing failed.");
        }

        System.out.println();
        System.out.println("------------------------------------------------");
        this.To_String();
    }

    public void setName() {
        System.out.print("Set owner's name: ");
        Scanner in = new Scanner(System.in);

        ownerName = in.nextLine();
    }

    public String getName() {
        return ownerName;
    }

    public void setInsuranceNumber() {
        System.out.print("Set insurance number: ");
        Scanner in = new Scanner(System.in);

        insuranceNumber = in.nextLine();
    }

    public String getInsuranceNumber() {
        return insuranceNumber;
    }

    public void setEngineType() {
        System.out.print("Set engine type: ");
        Scanner in = new Scanner(System.in);

        engineType = in.nextLine();
    }

    public String getEngineType() {
        return engineType;
    }
}

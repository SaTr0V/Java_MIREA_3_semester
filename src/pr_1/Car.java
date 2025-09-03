package pr_1;

import java.util.Scanner;

class Car {
    String model = "Mazda";
    String license = "М999ММ";
    String color = "Dark-Blue";
    int year = 2024;

    Car() {
        To_String();
    }

    Car(String model, String license, String color, int year) {
        this.model = model;
        this.license = license;
        this.color = color;
        this.year = year;

        To_String();
    }

    Car(String color) {
        this.color = color;

        To_String();
    }

    void To_String() {
        System.out.println("Model: " + this.model);
        System.out.println("License: " + this.license);
        System.out.println("Color: " + this.color);
        System.out.println("year: " + this.year);

        System.out.println("------------------------------------------------");
    }

    void Getter(String cmd) {
        Scanner in = new Scanner(System.in);

        boolean changed = false;
        while (!changed) {
            if (cmd.equalsIgnoreCase("year")) {
                System.out.print("New value of year: ");
                int changed_property = in.nextInt();

                this.year = changed_property;
                changed = true;
                System.out.println("The change was successful!");
            }
            else if (cmd.equalsIgnoreCase("model")) {
                System.out.print("New model: ");
                String changed_property = in.nextLine();

                this.model = changed_property;
                changed = true;
                System.out.println("The change was successful!");
            }
            else if (cmd.equalsIgnoreCase("license")) {
                System.out.print("New license: ");
                String changed_property = in.nextLine();

                this.license = changed_property;
                changed = true;
                System.out.println("The change was successful!");
            }
            else if (cmd.equalsIgnoreCase("color")) {
                System.out.print("New color: ");
                String changed_property = in.nextLine();

                this.color = changed_property;
                changed = true;
                System.out.println("The change was successful!");
            }
            else {
                System.out.println("Unknown command. Changing failed. Please, enter the correct one: ");
            }

        }

        System.out.println();
        System.out.println("------------------------------------------------");
        this.To_String();
    }
}

package vehicles;

import java.util.Scanner;

public abstract class Vehicle {
    // Поля
    private String model;
    private String license;
    private String color;
    private int year;
    private String ownerName;
    private String insuranceNumber;
    protected String engineType;

    // Конструктор
    public Vehicle(String model, String license, String color, int year) {
        this.model = model;
        this.license = license;
        this.color = color;
        this.year = year;
    }

    // Абстрактный метод
    public abstract String vehicleType();

    // Метод для вывода информации
    public void To_String() {
        System.out.println("Vehicle Type: " + vehicleType());
        System.out.println("Model: " + this.model);
        System.out.println("License: " + this.license);
        System.out.println("Color: " + this.color);
        System.out.println("Year: " + this.year);
        System.out.println("Owner's name: " + this.ownerName);
        System.out.println("Insurance number: " + this.insuranceNumber);
        System.out.println("Engine type: " + this.engineType);
        System.out.println("------------------------------------------------");
    }

    // Геттеры и сеттеры
    public String getModel() { return model; }

    public void setModel() {
        System.out.print("Set model: ");
        Scanner in = new Scanner(System.in);
        model = in.nextLine();
    }

    public String getLicense() { return license; }

    public void setLicense() {
        System.out.print("Set new license: ");
        Scanner in = new Scanner(System.in);
        license = in.nextLine();
    }

    public String getColor() { return color; }

    public void setColor() {
        System.out.print("Set new color: ");
        Scanner in = new Scanner(System.in);
        color = in.nextLine();
    }

    public int getYear() { return year; }

    public void setYear() {
        System.out.print("Set year: ");
        Scanner in = new Scanner(System.in);
        year = in.nextInt();
    }

    public String getOwnerName() { return ownerName; }

    public void setOwnerName() {
        System.out.print("Set owner's name: ");
        Scanner in = new Scanner(System.in);
        ownerName = in.nextLine();
    }

    public String getInsuranceNumber() { return insuranceNumber; }

    public void setInsuranceNumber() {
        System.out.print("Set insurance number: ");
        Scanner in = new Scanner(System.in);
        insuranceNumber = in.nextLine();
    }

    public String getEngineType() { return engineType; }

    public void setEngineType() {
        System.out.print("Set engine type: ");
        Scanner in = new Scanner(System.in);
        engineType = in.nextLine();
    }

    public void setProperty(String cmd) {
        Scanner in = new Scanner(System.in);

        if (cmd.equalsIgnoreCase("year")) {
            System.out.print("New value of year: ");
            this.year = in.nextInt();
            System.out.println("The change was successful!");
        }
        else if (cmd.equalsIgnoreCase("model")) {
            System.out.print("New model: ");
            in.nextLine(); // Очистка буфера
            this.model = in.nextLine();
            System.out.println("The change was successful!");
        }
        else if (cmd.equalsIgnoreCase("license")) {
            System.out.print("New license: ");
            in.nextLine(); // Очистка буфера
            this.license = in.nextLine();
            System.out.println("The change was successful!");
        }
        else if (cmd.equalsIgnoreCase("color")) {
            System.out.print("New color: ");
            in.nextLine(); // Очистка буфера
            this.color = in.nextLine();
            System.out.println("The change was successful!");
        }
        else {
            System.out.println("Unknown command. Changing failed.");
        }

        System.out.println("\n------------------------------------------------");
    }
}
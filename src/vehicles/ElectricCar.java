package vehicles;

import java.util.Scanner;

public class ElectricCar extends Car {
    private double batteryCapacity;

    public ElectricCar(String model, String license, String color, int year, double batteryCapacity) {
        super(model, license, color, year);
        this.engineType = "Electric";
        this.batteryCapacity = batteryCapacity;
    }

    // Специализированный тип
    @Override
    public String vehicleType() {
        return "Electric Car";
    }

    // Геттер и сеттер
    public double getBatteryCapacity() {
        return batteryCapacity;
    }

    public void setBatteryCapacity() {
        System.out.print("Set new battery capacity: ");
        Scanner in = new Scanner(System.in);
        this.batteryCapacity = in.nextDouble();
    }

    // Переопределяем метод To_String
    @Override
    public void To_String() {
        super.To_String();
        System.out.println("Properties specific for electric car:");
        System.out.println("Battery Capacity: " + batteryCapacity + " kWh");
        System.out.println("------------------------------------------------");
    }

    // Специфичный метод для электромобиля
    public void chargeBattery() {
        setBatteryCapacity();
        System.out.println("Charging battery of " + getModel() + "...");
        System.out.println("Battery at " + batteryCapacity + " kWh");
    }
}
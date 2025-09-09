package vehicles;

import java.util.Scanner;


public class ElectricCar extends Car {
    private double batteryCapacity;

    public ElectricCar(String model, String license, String color, int year, double batteryCapacity) {
        super(model, license, color, year);
        this.engineType = "Electric"; // Устанавливаем тип двигателя
        this.batteryCapacity = batteryCapacity;
    }

    // Геттер и сеттер для batteryCapacity
    public double getBatteryCapacity() {
        return batteryCapacity;
    }

    public void setBatteryCapacity() {
        System.out.print("Set new charge: ");
        Scanner in = new Scanner(System.in);

        batteryCapacity = in.nextDouble();
    }

    // Переопределяем метод To_String для отображения информации об электромобиле
    @Override
    public void To_String() {
        super.To_String(); // родительский метод
        System.out.println("Properties, only specific for this car:");
        System.out.println("Battery Capacity: " + batteryCapacity + " kWh");
        System.out.println("------------------------------------------------");
    }

    // Специфичный метод для электромобиля
    public void chargeBattery() {
        setBatteryCapacity();
        System.out.println("Charging battery of " + model + "...");
        System.out.println("Battery at " + batteryCapacity + " kWh capacity");
    }
}

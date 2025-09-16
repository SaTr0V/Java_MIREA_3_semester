package app;

import vehicles.Vehicle;
import vehicles.Car;
import vehicles.ElectricCar;

public class TestCar {
    public static void main(String[] args) {
        System.out.println("ТЕСТИРОВАНИЕ СИСТЕМЫ ТРАНСПОРТНЫХ СРЕДСТВ\n");

        System.out.println("1. СОЗДАНИЕ ОБЫЧНОГО АВТОМОБИЛЯ (через Vehicle):");
        Vehicle car = new Car("Audi", "A999AA", "Green", 2009);
        car.To_String();

        System.out.println("\n2. СОЗДАНИЕ ЭЛЕКТРОМОБИЛЯ (через Vehicle):");
        Vehicle e_car = new ElectricCar("Tesla Model S", "E001EE", "White", 2025, 100.0);
        e_car.To_String();

        System.out.println("\n3. ИЗМЕНЕНИЕ СВОЙСТВ ЧЕРЕЗ СЕТТЕРЫ:");

        // Изменяем свойства через методы родительского класса
        car.setColor();
        car.setYear();
        car.setOwnerName();
        car.setEngineType();

        System.out.println("\nUpdated info:");
        car.To_String();

        System.out.println("\n4. РАБОТА С ЭЛЕКТРОМОБИЛЕМ:");
        ElectricCar electricCar = (ElectricCar) e_car;

        // Используем специфичные методы ElectricCar
        electricCar.chargeBattery();

        System.out.println("\nInfo after recharge:");
        electricCar.To_String();

        System.out.println("\n5. ДОСТУП К СВОЙСТВАМ ЧЕРЕЗ ГЕТТЕРЫ:");
        System.out.println("Vehicle type: " + car.vehicleType());
        System.out.println("Model: " + car.getModel());
        System.out.println("Color: " + car.getColor());
        System.out.println("Engine type: " + car.getEngineType());

        System.out.println("\nElectric car:");
        System.out.println("Vehicle type: " + electricCar.vehicleType());
        System.out.println("Battery capacity: " + electricCar.getBatteryCapacity() + " kWh");
    }
}